package sorting;

import static sorting.Example.*;
import edu.princeton.cs.introcs.StdRandom;

public class Quick {
	public static void sortMy(Comparable [] a){
		// int mid = partitionMy(a, 0, a.length-1);
		// sortMy(a, 0, mid-1);	
		StdRandom.shuffle(a);
		sortMy(a, 0, a.length-1);		
	}

	public static void sortMy(Comparable [] a, int start, int end){
		if(start >= end)
			return;
		int mid = partition(a, start, end);
		sortMy(a, start, mid-1);
		sortMy(a, mid + 1, end);
	}

	public static int partitionMy(Comparable[] a, int start, int end){
		
		Comparable first = a[start];
		int i = start + 1;
		int j = end;
		while( i < j ){
			while( a[i].compareTo(a[start]) > 0 ){
				i++;
			}
			while( a[j].compareTo(a[start]) <= 0 )
				j--;
			if(i<j) //这里没有判断, 折腾了半天!
				exch(a, i, j);
		}
		exch(a, start, j);

		return j;

	}

	public static int partition(Comparable[] a, int start, int end){
		int i = start;
		int j = end + 1;
		while(true){
			while(less(a[++i], a[start]))
				if(i>end)
					break;
			while(less(a[start], a[--j]))
				if(j<0)
					break;
			if(i>=j)
				break;
			exch(a, i,j);
		}
		exch(a, start, j);
		return j;
	}

	public static void main(String [] args){
		Comparable[] a = new Comparable[1];
		System.out.println(partitionMy(a, 0, 0));
	}
}
