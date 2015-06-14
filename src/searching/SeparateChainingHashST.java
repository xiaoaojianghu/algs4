package searching;
public class SeparateChainingHashST<Key extends Comparable<Key>, Value>{
	//泛型好蛋疼, 泛型数组是??
	//得加static
	private static class Node{
		Object key;
		Object val;
		Node next;
		Node(Object k, Object v){
			key = k;
			val = v;
		}
	}
	
	private Node[] nodes = new Node[11];

	private int hash(Key k){
//		return (k.hashCode() & 07fffffff) % 9;
		return (k.hashCode() & 0x7fffffff) % 11;
	}

	public Value getMy(Key k){
		Node n = nodes[hash(k)];
		while(n != null && k.compareTo((Key) n.key) != 0)
			n = n.next;
		if(n == null)
			return null;
		return (Value) n.val;
	}

	public void put(Key k, Value v){
		Node n = nodes[hash(k)];
		Node temp = new Node(k, v);
		if(n == null){
			nodes[hash(k)] = temp;
			return;
		}
		while(n != null){
			if(k.compareTo((Key) n.key) == 0){
				n.val = v;
				return;
			}
			if(n.next == null)
				break;
			n = n.next;
		}
		n.next = temp;
	}

	public void putj(Key k, Value v){
		int i = hash(k);
		for(Node x = nodes[i]; x != null; x = x.next){
			if(k.equals(x.key)){
				nodes[i].val = v;
				return;
			}
		}
		nodes[i] = new Node(k,v);

	}

	public Value get(Key k){
		int i = hash(k);
		for(Node x = nodes[i]; x != null; x = x.next){
			if(k.equals(x.key)){
				return (Value)x.val;
			}
		}
		return null;
	}

}