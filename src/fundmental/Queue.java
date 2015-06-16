package fundmental;

import java.util.Iterator;
public class Queue<Item> implements Iterable<Item>{
	private static class Node<Item>{
		Item item;
		Node<Item> next;
	}

	private Node<Item> first;
	private Node<Item> last;
	private int size;

	private class IteratorQ<Item> implements Iterator<Item> {
		private Node<Item> cur;
		public IteratorQ(Node<Item> first){
			cur = first;
		}
		public Item next(){
			Item item = null;
			if(cur != null){
				item = (Item) cur.item;
			
			cur = cur.next;}
			return item;
			
		}
		public boolean hasNext(){
			return cur != null;
		}
		public void remove(){}
	}

	public Iterator<Item> iterator(){
		return new IteratorQ<Item>(first);
	}

	public void enqueueMy( Item i){
		Node<Item> newLast = new Node<Item>();
		newLast.item = i;
		if(last != null){
			last.next = newLast;
		}
		if(first == null){
			first = newLast;
		}
		last = newLast;
		size++;
	}

	public void enqueue(Item i){
		Node<Item> oldLast = last;
		last = new Node<Item>();
		last.item = i;
		if(isEmpty()){
			first = last;
		} else{
			oldLast.next = last;
		}
	}

	public Item dequeue(){
		Item i = first.item;
		first = first.next;
		if(isEmpty())
			last = null;
		size--;
		return i;
	}

	public boolean isEmpty(){
		return first == null;
	}

	public int size(){
		return size;
	}
	
	public String toString(){
		StringBuffer s = new StringBuffer();
		Node n = first;
		while(n != null){
			s.append(" ").append(n.item);
			n = n.next;
		}
		return s.toString();
	}

	public static void main(String [] args){
		String []test = "to be or not to - be - - that - - - is".split(" ");
		Queue<String> queue = new Queue<String>();
		for(String s :test){
			if(s.equals("-")){
				System.out.print(queue.dequeue() + " ");
			} else{
				queue.enqueue(s);
			}
		}
		for(String s : queue)
			System.out.println(s);
	}

}