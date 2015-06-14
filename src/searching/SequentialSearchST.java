package searching;

public class SequentialSearchST<Key, Value>{
	private class Node{
		Key k;
		Value v;
		Node next;
		Node(Key k, Value v){
			this.k = k;
			this.v = v;
		}
	}
	private Node first;


	public void put(Key k, Value v){
		Node cur = first;
		while(cur != null){
			if(cur.k.equals(k)){
				cur.v = v;
//				break; 查找到key的情况下, 只是跳出循环,后面的node照样添加
				return;
			}
			cur = cur.next;
		}
		cur = first;
		first = new Node(k,v);
		first.next = cur;
	}

	public Value get(Key k){
		Node cur = first;
		while(cur != null){
			if(k.equals(cur.k))
				return cur.v;
			cur = cur.next;//忘了,死循环
		}
		return null;
	} 

	public void show(){
		Node cur = first;
		while(cur != null){
			System.out.printf("%10s: %d", cur.k, cur.v);
			System.out.println();
			cur = cur.next;
		}
	}

	public String toString(){
		Node cur = first;
		StringBuffer s = new StringBuffer();
		String temp = "";
		while(cur != null){
			temp = cur.k + " :" + cur.v + "	  ";
			s.append(temp);
		}
		return s.toString();
	}
	
}