package sorting;

/*
 * 堆排序
 * 基本一次成功了,还不错!
 */

public class MaxPQsort<Key extends Comparable<Key>> {
	private static Comparable[] q;
	private static int N = 0;
	

	
	private static  boolean less( int i, int j){
		return q[i].compareTo( q[j] ) < 0;
	}

	private static void exch(int i, int j){
		Comparable t = q[i];
		q[i] = q[j];
		q[j] = t;
	}
	
	
	private void swim(int k){
		while(k > 1 &&  less(k/2, k)){
			exch(k, k/2);
			k /= 2;
		}
	}

	private static void sink(int k){
		while(2*k <= N){
			int j = 2*k;
			if(j<N && less(j,j+1)) j++;//通过j<N,当最后右子树不存在时,使得访问不会越界
			if(less(j,k)) 
				break; //sink到一定程度,就跳出.上面实现时候没有考虑到!
						//swim 不知道为啥中间过程没有跳出
			exch(j,k);
			k=j;
		}
	}

/*	public static void sortMy(Comparable[] a){
		Comparable [] t = new Comparable[a.length + 1];
		MaxPQsort q = new MaxPQsort(a.length);
		for(int i = 0; i < a.length; i++ ){
			q.insert(a[i]);
		}
		for(int i = 0; i < a.length && !q.isEmpty(); i++)
			a[i] = q.delMax();
	}*/

	public static void sortMy2(Comparable[] a){
		q = a; 
		N = a.length - 1;
		//构造堆
		for(int i = N/2; i > 0; i--){
			sink(i);
		}
		int num = N;
		for(int i = 1; i <= num; i++ ){
			exch(1, N--);
			sink(1);
		}
	}
}