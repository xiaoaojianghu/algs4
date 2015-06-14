package fundmental;

import java.util.Iterator;

/*
 * Iterable
 * 	iterate()
 * 
 * Iterator()
 * 	next()
 * 	hasNext()
 * 	
 */

public class Bag<Item> implements Iterable<Item>{
	private class Node {
		Item item;
		Node next;
	}

	private Node first;
	private int size;

	public void add(Item i) {
		Node oldfirst = first;
		first = new Node();
		first.item = i;
		first.next = oldfirst;
		size++;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size==0;
	}

	public Iterator<Item> iterator(){
		return new BagIterator<Item>();
	}

	class BagIterator<Item> implements Iterator<Item>{
		private Node cursor;
		BagIterator(){
			cursor = first;
		}
		public boolean hasNext(){
			return cursor != null;
		}

		public Item next(){
			// Item i = null;
			// if( hasNext() ){
			// 	 i = (Item) cursor.item;
			// }
			Item i = (Item) cursor.item; //不用上面注释的，hasNext已经保证？
			cursor = cursor.next;
			return i;
		}

		public void remove(){}
	}

	public static void main(String [] args){
		Bag bag = new Bag<String>();
		
		bag.add("a");
		bag.add("a");
		bag.add("a");
		
		for(Object i: bag){
			System.out.println(i);
		}
	}
}

// import java.util.Iterable
class IteratorOverview implements Iterable {
	public Iterator iterator(){
		return new IteratorImpl();
	}
}
//for(Object o: new IteratroOverview())
class IteratorImpl implements Iterator {
	public boolean hasNext(){return true;}

	public Object next(){ return null;}

	public void remove(){}
}