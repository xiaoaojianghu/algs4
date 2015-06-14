package sorting;

import static sorting.Example.*;

public class Quick3Way{
	public static void sortMy(Comparable[] a){
		sort(a, 0, a.length-1);
	}

	public static void sortMy(Comparable[] a, int lo, int hi){
		if(lo >= hi)
			return;
		int lt = lo;
		int gt = hi;
		Comparable first = a[lo];

		for(int i = lt + 1; i < gt; i++){
			int comp = a[i].compareTo(first);
			if( comp > 0 ){
//				exch(a, i, gt--);
				exch(a, i--, gt--);
				/*交换后,i代表的位置依然是未确定大小的.下一轮不用增加
				*/
			} else if( comp < 0 ){
				exch(a, i, lt++);
			}/* else{
				i++;
			}*/
			/*
			 *出错的两个地方, 
			 *1.书上用的while,自己受影响多了i++
			 *2.没有注意到gt交换后,i不用增加
			 *		实现细节,仔细看好边界条件.不能想当然
			 */
		}
		sortMy(a, lo, lt);
		sortMy(a, gt, hi);
	}

	public static void sort(Comparable[] a, int lo, int hi){
		if( lo >= hi)
			return;
		int lt = lo;
		int gt = hi;
		int i = lt + 1;
		Comparable v = a[lo];
		while(i <= gt){
			int comp = a[i].compareTo(v);
			if( comp > 0 ){
				exch(a, i, gt--);
			} else if(comp < 0)
				exch(a, i++, lt++);
			else
				i++;
		}
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
	}
}