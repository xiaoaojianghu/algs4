package graphs;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class DirectedCycle{
	private LinkedList<Integer> list;
	private boolean[] onstack;
	private int[] paths;
	private boolean[] mark;
	public DirectedCycle(Digraph g){
		int n = g.V();
		onstack = new boolean[n];
		mark = new boolean[n];
		paths = new int[n];
		for(int i = 0; i < n; i++){
			if(!hasCycle() && !mark[i])
				dfs(g, i);
		}
	}
	
	/*
	 * boolean数组 onstack 表示当前调用的堆栈(当前走的路径),
	 * 如果遇到新的点在当前走的路径中, 表示遇到了环
	 */
	private void dfs(Digraph g, int s){
		mark[s] = true;
		onstack[s] = true;
		for(int i : g.adj(s)){
			if(hasCycle())
				return;
			else if(!mark[i]){
				paths[i] = s;
				dfs(g, i);
			} 
			else if(onstack[i]){
				list = new LinkedList<Integer>();
				int temp = s;
				while(temp != i){
					list.push(temp);
					temp = paths[temp];
				}
				list.push(i);
				return;
			}
		}
	}

	public boolean hasCycle(){
		return list != null;
	}

	public Iterable<Integer> cycle(){
		return list;
	}

	public String toString(){
		String s = "";
		for(int i : list){
			s += i + " ";
		}
		return s;
	}

	public static void main(String[] args) throws Exception{
		Digraph g = new Digraph(new Scanner(new File("txt/tinyDG.txt")));
		DirectedCycle dc = new DirectedCycle(g);
		Out.println(dc);
	}
}
