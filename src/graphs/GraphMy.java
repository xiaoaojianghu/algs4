package graphs;

import java.util.*;

public class GraphMy{
	//用引用表示边是不可行的, 得用节点
	//直接用链表就可以了,这里自己实现的,多了很多麻烦 书上用的Bag
	private class Node{
		int no;
		Node next;
		public String toString(){
			return no + "";
		}
		
		public Node(int i){
			no = i;
		}

	}
	private Node[] nodes;
	private int e;

	public GraphMy(int v){
		nodes = new Node[v];
		for(int i = 0; i < nodes.length; i++)
			nodes[i] = new Node(i);
	}

	public GraphMy(Scanner s){
		String line = s.nextLine();
		int ns = Integer.parseInt(line);
		nodes = new Node[ns];
		for(int i = 0; i < nodes.length; i++)
			nodes[i] = new Node(i);
		line = s.nextLine();
		e = Integer.parseInt(line);	
		while(s.hasNextLine()){
			line = s.nextLine();
			String[] t = line.split(" ");
			addEdge(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
			
		}
	}
	public int V(){
		return nodes.length;
	}

	public int E(){
		return e;
	}

	public void addEdgeBefore(int v, int w){
		Node n = nodes[v];
		Node p = n;
		while(n != null){
			p = n;
			n = n.next;
		}
		p.next = nodes[w];
	}
	
	public void addEdge(Node to, int i){
		Node n = to;
		Node p = n;
		while(n != null){
			p = n;
			n = n.next;
		}
		p.next = new Node(i);
	}
	public void addEdge(int v, int w){
		addEdge(nodes[v], w);
		addEdge(nodes[w], v);

	}
	public Iterable<Integer> adj(int v){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Node n = nodes[v].next;
		while(n != null){
			list.add(n.no);
			n = n.next;
		}
		return list;
	}

	public String toString(){
		String s = "";
		for(Node n : nodes){
			Node to = n.next;
			while(to != null){
				s = s + n.no + " " + to.no + " ";
				to = to.next;
			}
			s += "\n";
		}	
		return s;
	}
}