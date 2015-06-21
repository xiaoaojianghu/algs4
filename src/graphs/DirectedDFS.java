package graphs;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 可达性
 * 从一个或者多个定点到图中其它顶点
 */
public class DirectedDFS{
	private boolean[] mark;

	public DirectedDFS(Digraph g, Iterable<Integer> s){
		mark = new boolean[g.V()];
		for(int i : s)
			dfs(g, i);
	}

	public DirectedDFS(Digraph g, int i) {
		mark = new boolean[g.V()];
			dfs(g, i);
	}

	private void dfs(Digraph g, int s){
		mark[s] = true;
		for(int i : g.adj(s))
			if(!mark[i])
				dfs(g, i);
	}

	public boolean mark(int v){
		return mark[v];
	}
	
	public String toString(){
		String s = "";
		for(int i = 0; i < mark.length; i++)
			if(mark[i])
				s += i + " ";
		return s;
	}

	public static void main(String[] args) throws Exception{
		Integer[] src = {1, 2, 6};
		ArrayList<Integer> srcs = new ArrayList<Integer>(Arrays.asList(src));
		Digraph g = new Digraph(new Scanner(new File("txt/tinyDG.txt")));
		Out.println(new DirectedDFS(g, srcs));
	}
}