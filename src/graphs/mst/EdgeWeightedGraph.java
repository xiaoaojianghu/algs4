package graphs.mst;
import graphs.Out;

import java.io.File;
import java.util.*;

public class EdgeWeightedGraph{
	private LinkedList<Edge>[] edges;
	private final int v;
	private int e;

	public EdgeWeightedGraph(int V){
		edges = new LinkedList[V];
		v = V;
		e = 0;
		for(int i = 0; i < edges.length; i++)
			edges[i] = new LinkedList<Edge>();
	}

	public EdgeWeightedGraph(Scanner s){
		this(s.nextInt());
		e = s.nextInt();
		s.nextLine();
		while(s.hasNextLine()){
			String[] a = s.nextLine().split(" ");
			int v = Integer.parseInt(a[0]);
			int w = Integer.parseInt(a[1]);
			double weight = Double.parseDouble(a[2]);
			Edge e = new Edge(v, w, weight);
			addEdge(e);
		}
	}

	public int V(){
		return v;
	}

	public int E(){
		return e;
	}

	public void addEdge(Edge e){
		int v = e.either();
		int w = e.other(v);
		edges[v].add(e);
		edges[w].add(e);
		this.e++;
	}

	public  Iterable<Edge> adj(int v){
		return edges[v];

	}

	public Iterable<Edge> edges(){
		HashSet<Edge> set = new HashSet<Edge>();
		for(LinkedList<Edge> list : edges)
			for(Edge e : list){
				int v = e.either();
				if(e.other(v) > v)
					set.add(e);
			}
		return set;

	}

	public String toString(){
		String s = "";
		for(Edge e : edges())
			s += e + "\n";
		return s;
	}

	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(new File("txt/tinyEWG.txt"));
		EdgeWeightedGraph g = new EdgeWeightedGraph(s);
		Out.println(g);
	}
}