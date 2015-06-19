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
		this(Integer.parseInt(s.nextLine()));
		String line = s.nextLine();
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
		e++;
	}

	public Iterable<Integer> adj(int v){
		return list[v];
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