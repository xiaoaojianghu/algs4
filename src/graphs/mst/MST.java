package graphs.mst;
import graphs.Out;

import java.util.*;
import java.io.*;

public class MST{
	private boolean[] mark;
	private PriorityQueue<Edge> pq;
	private LinkedList<Edge> edges;
	private double weight;
	private ArrayList<Integer> visited;

	public MST(EdgeWeightedGraph g){
		mark = new boolean[g.V()];
		pq = new PriorityQueue<Edge>();
		edges = new LinkedList<Edge>();
		visited = new ArrayList<Integer>();
		dfs(g, 0);
	}

	private void dfs(EdgeWeightedGraph g, int s){
		mark[s] = true;
		visited.add(s);
		while(visited.size() < g.V()){
			for(int i : visited){
				for(Edge e : g.adj(i)){
					int to = e.other(i);
					if(!mark[to]){
						
						pq.offer(e);
					}
				}
			}	
			Edge min = pq.poll();
			pq.clear();
			edges.add(min);
			weight += min.weight();
			int v = min.either();
			if(mark[v])
				v = min.other(v);
			mark[v] = true;
			visited.add(v);
		}	
	}

	public Iterable<Edge> edges(){
		return edges;
	}

	public double weight(){
		return weight;
	}

	public String toString(){
		return weight + "\n" + edges;
	}

	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(new File("txt/mediumEWG.txt"));
//		Scanner s = new Scanner(new File("txt/tinyEWG.txt"));
		EdgeWeightedGraph g = new EdgeWeightedGraph(s);
		MST m = new MST(g);
		Out.println(m);
	}
}	
