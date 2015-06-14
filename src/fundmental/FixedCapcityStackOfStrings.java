package fundmental;

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
//		FixedCapcityStackOfStrings stack = new FixedCapcityStackOfStrings(100);
//		FixedCapcityStack stack = new FixedCapcityStack(100);
		Stack<String> stack = new Stack<String>();
		String[] strings = "to be or not to - be - - that - - - is".split(" ");
		
		for(String item :strings){
//			String item = StdIn.readString();
			if(item.equals("-")){
				StdOut.print(stack.pop() + " ");
			} else{
				stack.push(item);
			}
		}
		
		StdOut.print("\nstack size:" + stack.size());
	}
}