package sorting;

public class Selecting {
	public static void sort(Comparable [] a){
		for(int i=0; i<a.length -1; i++){
			int max = i;
			for(int j = i+1; j < a.length; j++ ){
				if (a[j].compareTo(a[max]) > 0)
					max = j;
			}
			if( i != max ){
				Comparable t = a[i];
				a[i] = a[max];
				a[max] = t;
			}
		}
	}
}
