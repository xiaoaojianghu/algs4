package searching;

/*
* 自己最早实现的
*/

public class BST<Key extends Comparable<Key>, Value>{
	private Node root;
	private class Node{
		Key key;
		Value val;
		Node left;
		Node right;
		int N;
		public Node(Key k, Value v){
			 key = k;
			 val = v;
			 N = 1;
		}
	}

	public int size(){
		return size(root);
	}

	public int size(Node n){
		if(n == null)
			return 0;
		else
			return n.N;
	}


	public void put(Key k, Value v){
		root = put(root, k, v);
	}

	public Node put(Node root, Key k, Value v){
		if(root == null){
			return new Node(k,v);
		}
		int cmp = k.compareTo(root.key);
		if(cmp > 0)
			root.right = put(root.right, k, v);
		else if(cmp < 0)
			root.left = put(root.left, k, v);
		else
			root.val = v;
		root.N = size(root.left) + size(root.right);
		return root;

	}

	public Value get(Key k){
		Node node = get(root, k);
		return node == null? null : node.val;
	}

	public Node get(Node root, Key k){
		if(root == null)
			return null;
		int cmp = k.compareTo(root.key);
		if(cmp > 0)
			return get(root.right, k);
		else if(cmp < 0)
			return get(root.left, k);
		else
			return root;
	}

	public void show(){
		show(root);
	}

	public void show(Node n){
		if(n == null)
			return;
		show(n.left);
		System.out.println(n.key + ": " + n.val + "  nodes:" + n.N);
		show(n.right);
	}
	//put后,怎么更新父节点的N??
	//写错了,node里面没有方法
	/*public void put(Key k, Value v){
		if(root == null){
			root = new Node();
			root.key = k;
			root.val = v;
			root.N = 1;
			return;
		}
		int cmp = k.compareTo(root.key);
		if(cmp > 0)
			root.right.put(k, v);
		else if(cmp < 0)
			root.left.put(k, v);
		else
			root.val = v;

	}

	public Value get(Key k){
		if(root == null)
			return null;
		int cmp = k.compareTo(root.key);
		if(cmp > 0)
			return root.right.get(k);
		else if( cmp < 0 )
			return root.left.get(k);
		else 
			return root.val;
	}

	public void show() {
		
	}*/
}