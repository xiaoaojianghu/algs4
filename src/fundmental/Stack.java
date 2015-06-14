package fundmental;

public class Stack<Item> {
	private class Node {
		Item item;
		Node next;
		
	}

	private Node first;
	private int size;

	public void pushMy(Item i){
		Node node = new Node();
		node.item = i;
		node.next = first;

		first = node;
		size++;
	}

	public void push(Item i){
		Node oldfirst = first;
		first = new Node();
		first.item = i;
		first.next = oldfirst;
		size++;
	}

	public Item pop(){
		if (first == null)
			return null;
		Item item = first.item;
		first = first.next;
		size--;
		return item;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}
	
}