package fundmental;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args){
		int[] array = new int[20];
		for(int i= 0; i< 20; i++){
			array[i] =  i;
		}
		System.out.println(Arrays.toString(array));
		
		System.out.println(binarySearch(array,10,100));

		System.out.println(factorial(5));
	}
	
	public static int binarySearch(int[] a, int size, int key){
		int pos = -1, head =0, tail = 19;
		while(head <= tail){ //一开始忘了加等号,导致找不到值.实现比看代码简单
			pos = (head+tail)/2;
			if(a[pos] == key){
				return pos;
			} else if(a[pos] > key){
				tail = pos - 1;
			} else {
				head = pos + 1;
			}
		}
		return -1;
	}

	public static int factorial(int n){
		if (n > 1)
			return n*factorial(n-1);
		else
			return 1;
	}
}
