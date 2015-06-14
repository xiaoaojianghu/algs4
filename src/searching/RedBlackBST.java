package searching;


//2015年6月14日12:47:05 put完成,回家后的第一个上午
// 两个问题  h.left.left 竟然没有问题, 仔细看一下. 2.put递归调用忘了返回值赋值给h.left = put(h.left, k, v)
public class RedBlackBST<Key extends Comparable<Key>, Value>{
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	private class Node{
		Key key;
		Value val;
		Node left, right;
		boolean color;
		int N;
		public Node(Key k, Value v, boolean color){
			key = k;
			val = v;
			this.color = color;
			N = 1;
		}
	}

	public Node rotateLeftMy(Node e){
		Node temp = new Node(e.key, e.val, e.color);
		temp.N = e.N;//???
		temp.right = e.right;
		temp.left = e.left;


		e = e.right;
		e.color = temp.color;
		Node s_left = e.left;
		e.left = temp;
		//e.N ??

		temp.color = BLACK;
		temp.right = s_left;

		return e;
	}

	public Node rotateLeft1(Node h){
		Node x = h.right;
		x.color = h.color;
		h.color = RED;
		h.right = x.left;
		x.N = h.N;
		x.left = h;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}

	private Node rotateLeft(Node h){
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}

	private Node rotateRight(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}

	private Node putMy(Node h, Key k, Value v){
		if(h == null){
			h = new Node(k, v, RED);
			return h;
		}

		int cmp = k.compareTo(h.key);
		if(cmp > 0)
			h.right = putMy(h.right, k, v);
		else if(cmp < 0)
			h.left = putMy(h.left, k, v);
		else
			h.val = v;
		//书上的实现充分利用变化后的关系, 代码简洁
		//这个有bug
		if(isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if(isRed(h.right) && isRed(h.left))
			flipColors(h);
		if(isRed(h.left) && isRed(h.left.right)){
			h.left = rotateLeft(h.left);
			h = rotateRight(h);
//			flipColors(h);
		}
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}
	
	public void put(Key k, Value v){
		root = putMy(root, k, v);
	}

	public Node put(Node h, Key k, Value v){
		if(h == null)
			return new Node(k, v, RED);
		int cmp = k.compareTo(h.key);
		if(cmp > 0)
			h.right = put(h.right, k, v);
		else if(cmp < 0)
			h.left = put(h.left, k, v);
		else
			h.val = v;

		//当插入的值是中间大小时, 首先左旋得到第二个if 
		//第二个if操作后得到第三个if(也就是左右子树都是红色的树)
		if(isRed(h.right) && !isRed(h.left))
			h = rotateLeft1(h);
		if(isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if(isRed(h.right) && isRed(h.left))
			flipColors(h);

		h.N = size(h.left) + size(h.right) + 1;
		return h;

	}


	private boolean isRed(Node h){
		if(h == null)
			return false;
		return h.color == RED;
	}

	private int size(Node h){
		if(h == null)
			return 0;
		return h.N;
	}

	private void flipColors(Node h){
		h.left.color = BLACK;
		h.right.color = BLACK;
		h.color = RED;
	}
	
	public Key select(int n){
		Node r = select(root, n);
		if(r == null)
			return null;
		return r.key;
	}

	public Node select(Node node, int n){
		if(node == null)
			return null;
		int numl = size(node.left);
		if(n < numl)
			return select(node.left, n);
		if(n > numl)
			return select(node.right, n-numl-1);
		return node;
	}

	public int rank(Key k){
		return rank(root, k);
	}

	public int rank(Node n, Key k){
		if(n == null)
			return 0;
		int cmp = k.compareTo(n.key);
		if(cmp > 0)
			return rank(n.right, k) + size(n.left)+1;
		if(cmp < 0)
			return rank(n.left, k);
		return size(n.left);
	}
	
	public void show(){
		show(root);
	}
	
	int number = 0;
	public void show(Node n){
		if(n == null)
			return;
		show(n.left);
		
		System.out.println(number + ":" + n.key + ": " + n.val + "  nodes:" + n.N + "\t" + n.color);
		number++;
		show(n.right);
	}
}