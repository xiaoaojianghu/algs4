package sorting;

/*
* 堆排序
* 堆的序号从1开始, 数组从0开始, 所以需要一点转换
* 只有less exch 中减1就可以了

*完成排序啦
* 2015年6月6日19:48:09
*/

public class Heap {
	private static boolean less(Comparable [] a, int i, int j){
		return a[i-1].compareTo(a[j-1]) < 0;
	}

	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i-1];
		a[i-1] = a[j-1];
		a[j-1] = t;
	}

	//小根堆, 大根堆 傻傻分不清,写的乱七八糟!
	//明确大根堆, 分析清楚!!!!
	private static void sink(Comparable[] a, int i, int N){
		while( 2*i <= N ){
			int max = 2*i;
			if(max < N && less(a, max, max + 1))//写出m--,和m-1完全不一样
				max++;
//			if(less(a, i, max))
			if(less(a, max, i))
				break;
			exch(a, i, max);
			i = max;
		}
	} 

	public static void sortMy(Comparable[] a){
		int N = a.length;
		for(int i = N/2; i > 0; i--)
			sink(a, i, N);
		for(int i = 1; i <= a.length; i++){
			// exch(a, i, N); hehehe
			exch(a, 1, N);
			// sink(a, i, N--);
			sink(a, 1, --N);
		}
	}

	public static void sort(Comparable[] a){
		int N= a.length;
		for(int i = N/2; i > 0; i--)
			sink(a, i, N);
		while(N > 1){
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}
}