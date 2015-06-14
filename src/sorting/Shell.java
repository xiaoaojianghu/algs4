package sorting;
import static sorting.Example.*;

public class Shell {
	/*
	*
	*/
	public static void sortMy(Comparable[] a){
		int N = a.length;
		int step = 1;
		while(step < N)
			step = step*3 + 1;
		
		for(int i = 0; i < N && step > 0; i += step){ //一开始漏了 step>0， 导致死循环
			for(int j = 0; j < step; j++){//每个分组的开头元素 a[j]
				for(int k = i+j+1; k< N; k += step){ // i+j, i+j+step, i+j+2*step ....
													// 插入排序
					for(int l = k; l > 0 && less (a[l-1], a[l]); l--){
						exch(a, l-1, l);
					}
				}
			}
			step /= 3;
		}
	}

	public static void sort (Comparable[] a){
		int N = a.length;
		int step = 1;
		while( step < N) step = 3 * step + 1;

		while(step > 0){
			for( int i = step; i < N; i++ ){
				for( int j = i; j-step >= 0 && less(a[j-step], a[j]); j-=step){
					exch(a, j-step, j);
				}
			}
			step /= 3;
		}
	}
	
	
}