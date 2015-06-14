package sorting;

import edu.princeton.cs.introcs.*;

public class Example{
	public static void sort(Comparable[] a){

	}

	public static boolean less(Comparable u, Comparable v){
		return u.compareTo(v) < 0;
	}

	public static void exch(Comparable[] a, int i, int j){
		Comparable temp = a[i];
		a[i]  = a[j];
 		a[j] = temp;	
		
	}

	public static void show(Comparable[] a){
		for(Comparable i: a){
			StdOut.print(i + " ");
		}
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a){
		for(int i = 0; i < a.length - 1; i++){
			if(less(a[i], a[i+1]))
				return false;
		}
		return true;
	}

	public static void main(String [] args){
		// String [] a = In.readStrings();
		String  s = " be or not to - be - - that - - - "
				+ "is It follows immediately from the contract"
				+ " for compareTo that the quotient is an "
				+ "equivalence relation on C";
		s = "SHELLSORTEXAMPLE";
		s = "1235433335597908";
		String[] b = s.split("");
		String[] c = new String[b.length-1];
		for(int i = 1; i<b.length;i++){
			c[i-1] = b[i];
		}
		String [] a = {"3", "2", "1", "4"};
		
//		Shell.sortMy(a);
//		MergeDownToUp.sortMy(a);
//		Quick.sortMy(a);
//		MaxPQsort.sortMy2(b);
		Heap.sort(b);
//		Quick3Way.sortMy(a);
		// MergeUpToDown.sortMy(a);
		show(b);
	}
}