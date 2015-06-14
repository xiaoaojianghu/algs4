package sorting;

import static sorting.Example.*;

public class MergeUpToDown {
	private static  Comparable aux[];
	public static void sortMy(Comparable[] a){
		aux = new Comparable[a.length];
		sortMy(a, 0, a.length-1);
	}

	public static void sortMy(Comparable[] a, int start, int end){
		int mid = (end + start)/2;
		if( mid > 0)
			sortMy(a, 0, mid);
		if( mid+1 < end)
			sortMy(a, mid+1, end);
		merge(a, start, mid, end);
		
	}

	public static void mergeMy(Comparable[] a, int start, int mid, int end){
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

	public static void merge(Comparable[] a, int start, int mid, int end){
		for(int i = start; i <= end; i++){
			aux[i] = a[i];
		}

		int i = start;
		int j = mid + 1;

		for(int k = start; k <= end; k++){
			if(i > mid)
				a[k] = aux[j++];
			else if( j > end)
				a[k] = aux[i++];
			else if( less(aux[i], aux[j]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
			
		}
	}

	public static void sort(Comparable [] a){
		int N = a.length;
		aux = new Comparable[N];
		sort(a, 0, N-1);
	}

	public static void sort(Comparable [] a, int start, int end){
		if(start >= end)
			return;
		int mid = (start + end)/2;
		sort(a, start, mid);
		sort(a, mid + 1, end);
		merge(a, start, mid, end);
	}
	
}