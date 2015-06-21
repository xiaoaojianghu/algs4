package graphs;
import java.util.*;
import java.io.*;

public class Digraph{
	private LinkedList<Integer>[] list;
	private int v, e;

	public Digraph(int v){
		list = new LinkedList[v];
		for(int i = 0; i < v; i++){
			list[i] = new LinkedList<Integer>();
		}
		this.v = v;
	}

	public Digraph(Scanner s){
		this(Integer.parseInt(s.nextLine()));
		String line = s.nextLine();
		e = Integer.parseInt(line);	
		while(s.hasNextInt()){
			addEdge(s.nextInt(), s.nextInt());
			
		}
	}
	public void addEdge(int v, int w){
		list[v].add(w);
	}


	public Iterable<Integer> adj(int v){
		return list[v];
	}

	public Digraph reverse(){
		Digraph g = new Digraph(v);
		for(int src = 0; src < v; src++){
			for(int to : list[src]){
				g.addEdge(to, src);
			}
		}
		return g;
	}

	public int V(){
		return v;
	}

	public int E(){
		return e;
	}
	public String toString(){
		String s = "";
		for(int src = 0; src < v; src++){
			for(int to : list[src]){
				s  = s + src + " " + to + "\n";
			}
		}
		return s;
	}

	public static void main(String[] args) throws Exception{
		Digraph g = new Digraph(new Scanner(new File("txt/tinyDG.txt")));
		Out.println(g);
		Out.println("");
		Out.println(g.reverse());
	}
}