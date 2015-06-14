package sorting;

import static sorting.Example.*;

public class MergeDownToUp {

	public static Comparable[] aux;
	public static void sortMy(Comparable[] a){
		aux = new Comparable[a.length];
		int N =  a.length;
		/*
		*第一层循环是每组的长度,从2到小于N的最大值
		*第二层循环是将每个每组进行排序
		*后面的两层循环是组内插入排序
		*为什么这么多循环呢,希尔排序也是用的循环层数过多

		搞了这么多没用啊!注释掉才发现


		*/

		//分组, 归并,完了!!!没有别的乱七八糟的东西
		for(int length = 2; length < N; length *= 2){ //每组长度每次都是原来的两倍,
														//每组分别有2个,4个...元素
			// for(int i = 0; i < length; i+=length){
			// 	for(int j = i; j - i < length; j++){
			// 		for(int k = j; k-i >= 0 && less(a[k], a[k+1]); k--){
			// 			exch(a, k, k+1);
			// 		}
			// 	}
			// }
			for(int i = 0; i < N; i += 2*length){ //两组两组的归并,i每次跳过两组的长度
				int end = i + 2 * length - 1;
				if(end > N-1)
					end = N-1;
				merge(a, i, i+length-1, end);//i+length-1 有可能越界, 上面i<N, 应该为i < N-length;
											//i落在最后一组,就不用归并了
			}
			
		}
	}

	public static void merge(Comparable[] a, int start, int mid, int end){
		for(int i = start; i <= end; i++){
			aux[i] = a[i];
		}
		int i = start;
		int j = mid + 1;
		int index = start;
		while( i <= mid && j <= end){
			if(less(aux[i] , aux[j])){
				a[index++] = aux[j++];
			} else {
				a[index++] = aux[i++];
			}
		}

		while(i <= mid){
			a[index++] = aux[i++];
		}

		while(j <= end){
			a[index++] = aux[j++];
		}
	}

	public static void sort(Comparable[] a){
		int N = a.length;
		for(int length = 2; length < N; length = length + length){
			for(int i = 0; i < N - length; i = i + length + length){
				merge(a, i, i + length - 1, Math.min(i, N-1));
			}
		}
	}
	
	
}