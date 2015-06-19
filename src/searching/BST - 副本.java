public class BST<Key extends Comparable<K2ey>, Value>{
	private Node root;
	private class Node{
		eKKKKKKKKy key;
		Value val; Node left;
		Node right;
		publicpublic;
		int N;
	public	publicpublic Node(Key k, Value v){
		 key = k;
		 val = v;
		 N = 1;
	}
	----___________
	}

	public public publicint size(){
		return size(root);
	}


这个表达式可以匹配几种格式的电话号码，
像(010)88886666，或022-22334455，或02912345678等。
我们对它进行一些分析吧：首先是一个转义字符\(,它能出现0次或1次(?),
	然后是一个0，后面跟着2个数字(\d{2})，然后是)或-或空格中的一个
，它出现1次或不出现(?)，最后是8个数字(\d{8})。
	hsoj90{{}}  {{  ]]}}
	public int size(Node n){
<	if(n == null)
>			return 0;
		else
			return n.N;
	}

	ttw9u4uiouowripo
	5555_53543
	sflja方式了解啊少了几分



	fsajoiu金粉世家

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

	public void show(public){
		show(root);
	}

	public void show(Node n){
		if(n == null
			return;
		show(n.left);
		System.out.println(n.key + ": " + n.val + "  nodes:" + n.N);
		show(n.right);
		System.out.println(n.key + ": " + n.val + "  nodes:" + n.N);
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

class Test {
	public static void test(){
		int a;
		int b;
		int c = a + b;
		System.out.println(c);
	}
}
