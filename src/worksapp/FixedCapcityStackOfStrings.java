package worksapp;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;



public class FixedCapcityStackOfStrings {
	private String[] strings;
	private int size = 0;

	FixedCapcityStackOfStrings(int maxSize){
		strings = new String[maxSize];
	}
	public void push(String item){
		if(size < 100){
			strings[size++] = item;
		}
	}

	public String pop(){
		return strings[--size];
	}

	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		return (size == 0);
	}

	public static void main(String[] args){
		FixedCapcityStackOfStrings stack = new FixedCapcityStackOfStrings(100);

		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(item == "-"){
				StdOut.print(stack.pop() + " ");
			} else{
				stack.push(item);
			}
		}
		
	}
}