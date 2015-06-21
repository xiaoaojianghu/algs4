package graphs;

import java.io.File;
import java.util.Scanner;

/*
 * 
 * 有向图可达性
 * 从一个顶点到图中其它顶点
 * 2015年6月21日17:12:00
 * 有向图完成 
 */
public class TransitiveClosure{
	private	DirectedDFS[] dfs;
	public TransitiveClosure(Digraph g){
		dfs = new DirectedDFS[g.V()];
		for(int i = 0; i < g.V(); i++){
			dfs[i] = new DirectedDFS(g, i);
		}
	}

	public boolean reachable(int v, int w){
		return dfs[v].mark(w);
	}

	public static void main(String[] args) throws Exception{
		Integer[] src = {1, 2, 6};
		Digraph g = new Digraph(new Scanner(new File("txt/tinyDG.txt")));
		TransitiveClosure t = new TransitiveClosure(g);
		Out.println(t.reachable(9, 10));
	}
} 