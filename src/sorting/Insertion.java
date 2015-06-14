package sorting;

import static sorting.Example.*;

public class Insertion{
	public static void sortMy(Comparable [] a){
		for(int i = 1; i < a.length; i++){
			int pos = i;
			Comparable temp = a[i];
			for(int j = i-1; j >= 0; j--){
				if(less(a[j], temp)){ 	//这里的temp 一开始写成了a[i],后面a[i]会被擦掉。debug才找出原因
					a[j+1] = a[j];
					pos = j;
				}
			}
			a[pos] = temp;
		}
	}
	
	public static void sort(Comparable[] a){
		for(int i = 1; i < a.length; i++){
			for(int j = i; j > 0 && less(a[j-1], a[j]); j--){
				exch(a, j-1, j);//只要i 比前面的小,就交换,一直换到底!
			}
		}
	}
}