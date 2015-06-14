package searching;
import fundmental.Queue;

/*
 * 2015年6月9日21:29:03
 * 好慢哦,白天纠结了要去不去雷盼婚礼
 * 整理了算法动态规划例题,晚上改正了昨天delete的bug,实现了keys()
 * 
 * 昨天delete的bug:
 * 	if后面没有return,就得使用
 * 	if
 *  else if
 *  else
 */

	/*
	*框架
	* 
	*return 就是为了照顾传进来的node是null的情况, 
	* 如果传进来的node不是null,不用返回也是可以的
	* 返回好像也没啥损失,反正还是把原来对象的引用指向原来的对象.
	* 其中这个对象更新了一些内容
	*/
/*	root = put(root, k, v){
		if(root == null)
			return new Node();
		root.left = put(root.left, k, v);
		root.right = put(root.right, k, v);

		return root;
	}*/

public class BSTmy<Key extends Comparable<Key>, Value>{
	private Node root;
	private class Node{
		Key key;
		Value val;
		Node left, right;
		int N;
		public Node(Key k, Value v){
			key = k;
			val = v;
			N = 1;
		}
	}

	public void put(Key k, Value v){
		root = put(root, k, v);
	}

	public Node put(Node n, Key k, Value v){
		if(n == null){
			return new Node(k, v);
		}
		int cmp = k.compareTo(n.key);
		if(cmp > 0){
			n.right = put(n.right, k, v);
		} else if(cmp < 0){
			n.left = put(n.left, k, v);
		} else{
			n.val = v;
		}
		n.N = size(n.left) + size(n.right) + 1;
		return n;
	}

	public int size(Node n){
		if(n == null)
			return 0;
		return n.N;
	}

	public Value get(Key k){
		return getNotRec(root, k);
	}
	
	public Value getNotRec(Node n, Key k){
		if(n == null)
			return null;
		Node cur = n;
		while(cur != null){
			int cmp = k.compareTo(n.key);
			if(cmp > 0)
				cur = cur.right;
			else if(cmp < 0)
				cur = cur.left;
			else
				return cur.val;
		}
		return null;
	}

	public Value get(Node n, Key k){
		if(n== null)
			return null;
		int cmp = k.compareTo(n.key);
		if(cmp > 0){
			return get(n.right, k);
		} else if(cmp < 0){
			return get(n.left, k);
		} else
		 	return n.val;
	}

	public void show(){
		show(root);
	}
	
	int number = 0;
	public void show(Node n){
		if(n == null)
			return;
		show(n.left);
		
		System.out.println(number + ":" + n.key + ": " + n.val + "  nodes:" + n.N);
		number++;
		show(n.right);
	}

	public Node max(){
		Node vnode = root;
		Node cur = root;
		while(cur != null){
			vnode = cur;
			cur = cur.right;
		}
		return vnode;
	}

	public Node min(){
		Node vnode = root;
		Node cur = root;
		while(cur != null){
			vnode = cur;
			cur = cur.left;
		}
		return vnode;

	}

	public Key minRecur(){
		return min(root).key;
	}

	public Node min(Node n){
		if(n == null)
			return null;
		if(n.left == null){
			return n;
		} else 
			return min(n.left);
	}
	
	public Node max(Node n){
		if(n == null)
			return null;
		if(n.right == null){
			return n;
		} else 
			return max(n.right);
	}

	public Key floor(Key k){
		Node r = floor(root, k);
		if(r == null)
			return null;
		return r.key;
	}

	/*
	*实现时候,只管左右就可以,剩下的交给递归
	*/
	public Node floorMy(Node n, Key k){
		if(n == null)
			return null;
		int cmp = k.compareTo(n.key);
		Node result = null;
		if(cmp > 0){ //k大于当前节点值, 
			result = n;//暂时设置为当前节点值
			Node resRi = floor(n.right, k);
			if(resRi != null)
				result = resRi; //右子树有小于k的,更新floor值
		} else if( cmp < 0)// k 比当前节点小,floor值一定在左子树或者null
			result = floor(n.left, k);
		else
			result = n;
		return result;
		
	}

	//2015年6月8日14:28:25
	public Node floor(Node n, Key k){
		if(n == null)
			return null;
		int cmp = k.compareTo(n.key);
		if(cmp == 0)
			return n;
		if(cmp < 0)
			return floor(n.left, k);
		Node x = floor(n.right, k);
		if(x == null)
			return n;
		return x;
	}

	public Key select(int n){
		Node r = select(root, n);
		if(r == null)
			return null;
		return r.key;
	}

	//忘了用size()了,多了很多判断null
	// 节点编号按照从一开始的, 书上是 从0开始
	public Node selectMy(Node node, int n){
		if(node == null)
			return null;
		int numl = 0;
		if(node.left != null)
			numl = node.left.N;
		if(n == numl + 1)
			return node;
		if(n > numl + 1)
			return select(node.right, n-numl-1);
		return select(node.left, n);
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




	public int rankMy(Node n, Key k){
		if(n == null)
			return 1;
		int cmp = k.compareTo(n.key);
		int r = 0;
		if(n.right != null)
			r = n.right.N;
		if(cmp > 0)
			return rank(n.right, k) + n.N - r;
		if(cmp < 0)
			return rank(n.left, k);
		return n.N -r;
	}
//搞了半天不知道哪里错了,还是用递归吧,耗费时间太多不知猴年马月才看完这本书!
/*	public int rank(Key k){
		//找到key的floor,再找到它的父节点
		Node floor = floor(root, k);
		if(floor == null)
			return 0;
		Node parent = parent(root, floor);
		//floor除了右子树的节点个数
		int flag = 0;
		if(k.compareTo(floor.key) != 0)
			flag = 1;
		int r = 0;
		if(floor.right != null)
			r = floor.right.N;
		int l = floor.N - r;
		if(parent == null)
			return l + flag;

		return parent.N - floor.N + l + flag;
	}

	private Node parent(Node n, Node floor){
		if(n == null || n.right == null)
			return null;
		if(n.right != null && n.right.key.compareTo(floor.key) ==0)
			return n;
		int cmp = n.key.compareTo(floor.key);
		if(cmp > 0)
			return parent(n.left, floor);
		if(cmp < 0)
			return parent(n.right, floor);
		return null;
	}*/

	public void deleteMinMy(){
		deleteMinMy(root.left, root);
	}

	public void deleteMinMy(Node node, Node parent){
		//删掉根节点
		if(node == null){
			parent = parent.right;
			return;
		}
		if(node.left == null){
			if(node.right != null)
				parent.left = node.right;
			else
				parent.left = null;
			return;
		} 
		deleteMinMy(node.left, node);
	}
	
	public void deleteMin(){
		root = deleteMin(root);
	}
	//又忘了return了,这不是指针,涉及到内容的修改,就需要return
	public Node deleteMin(Node n){
		if(n.left == null)
			return n.right;
		n.left = deleteMin(n.left);
		n.N = size(n.left) + size(n.right) + 1;
		return n;
	}
	
	public Node deleteMax(Node n){
		if(n.right == null)
			return n.left;
		n.right = deleteMax(n.right);
		n.N = size(n.left) + size(n.right) + 1;
		return n;
	}


	public void deleteMy(Key key){
		// Node toDel = floor(root, key);
		root = delete(root, key);
	}

	public Node delete(Node n, Key k){
		if (n == null)
			return null;
		int cmp = k.compareTo(n.key);
		if(cmp > 0)
			n.right = delete(n.right, k);
		else if(cmp < 0)
			n.left = delete(n.left, k);
		else {
			if(n.right == null)
				return n.left;
			if(n.left == null)
				return n.right;
			Node minR = min(n.right);
			minR.right = deleteMin(n.right);
			minR.left = n.left;
			n = minR;
		}
		n.N = size(n.left) + size(n.right) + 1;
		return n;
	}

	public Node deleteMy(Node n, Key k){
		if(n == null)
			return null;
		int cmp = k.compareTo(n.key);
		if(cmp > 0)
			n.right = deleteMy(n.right, k);
		else if(cmp < 0)
			n.left = deleteMy(n.left, k);
		else{ //书上的简洁多了, 左右子树有一个是null就返回另一半
			//不是左右子树都不是null才向右边借
			//我考虑的是哪个不是null,去哪个借
			if(n.right == null && n.left == null)
				return null;
			else if(n.right != null){

				Node min = min(n.right);
				min.right = deleteMin(n.right);
				min.left = n.left;
				n = min;
			}
			else if(n.left != null){

				Node max = max(n.left);
				n.left = deleteMax(n.left);
				max.right = n.right;
				max.left = n.left;
				max.N = size(max.left) + size(max.right) + 1;
				n = max;
			}
			n.N = size(n.left) + size(n.right) + 1;
		}

		return n;
	}

	public Iterable keysMy(Key lo, Key hi){
		return keysMy(root, lo, hi);
	}

	private Queue q = new Queue();
	public Iterable keysMy(Node n, Key lo, Key hi){
		if(n == null)
			return q;
		keysMy(n.left, lo, hi);
		int cmp = lo.compareTo(n.key);
		int cmphi = hi.compareTo(n.key);
		if( cmp <= 0 && cmphi >= 0)
			q.enqueue(n.key);
		keysMy(n.right, lo, hi);
		return q;
	}

	public Iterable keys(){
		return keys(min().key, max().key);
	}

	public Iterable keys(Key lo, Key hi){
		Queue q = new Queue();
		keys(q, root, lo, hi);
		return q;
	}

	public void keys(Queue q, Node n, Key lo, Key hi){
		if(n == null)
			return;
		int cmplo = lo.compareTo(n.key);
		int cmphi = hi.compareTo(n.key);
		if(cmplo < 0)
			keys(q, n.left, lo, hi);
		if(cmplo <= 0 && cmphi >= 0)
			q.enqueue(n.key);
		if(cmphi > 0)
			keys(q, n.right, lo, hi);
		

	}
}