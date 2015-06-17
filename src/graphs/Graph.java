package graphs;

import java.util.*;

public class Graph{
	//书上用的Bag
	private final int v;
	private int e;
	private LinkedList<Integer>[] list;

	public Graph(int v){
		list = new LinkedList[v];
		for(int i = 0; i < v; i++){
			list[i] = new LinkedList<Integer>();
		}
		this.v = v;
	}

	public Graph(Scanner s){
		String line = s.nextLine();
		int ns = Integer.parseInt(line);
		
		this.v = ns;
		list = new LinkedList[v];
		for(int i = 0; i < v; i++){
			list[i] = new LinkedList<Integer>();
		}
		
		line = s.nextLine();
		e = Integer.parseInt(line);	
		while(s.hasNextLine()){
			line = s.nextLine();
			String[] t = line.split(" ");
			addEdge(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
			
		}
	}
	public int V(){
		return v;
	}

	public int E(){
		return e;
	}

	
	public void addEdge(int v, int w){
		list[v].add(w);
		list[w].add(v);
	}
	public Iterable<Integer> adj(int v){
		int len = list[v].size();
		Integer[] a = new Integer[len];
		for(int i = 0; i < len; i++){
			a[i] = list[v].get(i);
		}
		return a;
	}

	public String toString(){
		String s = "";
		for(int i = 0; i < list.length; i++){
			for(int j : list[i]){
				s = s + i + " " + j + "|";
			}
			s += "\n";
		}	
		return s;
	}
}