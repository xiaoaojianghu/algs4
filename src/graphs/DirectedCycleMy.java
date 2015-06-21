package graphs;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class DirectedCycleMy{
	private boolean hasCycle;
	private LinkedList<Integer> list;
	private boolean[] mark;
	public DirectedCycleMy(Digraph g){
		list = new LinkedList<Integer>();
		mark = new boolean[g.V()];
		for(int i = 0; i < g.V(); i++){
			if(!hasCycle && !mark[i])
				dfs(g, i);
		}
	}

	LinkedList<Integer> stack = new LinkedList<Integer>();
	private void dfs(Digraph g, int s){
		stack.push(s);
		mark[s] = true;
		for(int i : g.adj(s)){
			if(!hasCycle && !mark[i]){
				dfs(g, i);
			} else if(!hasCycle && stack.contains(i)) {
				hasCycle = true;
				int temp = stack.pop();
				int no = 0;
				while(temp != i){
					list.push(temp);
					temp = stack.get(no);
					no++;
				}		
				list.push(i);
				return;
			}
		}
		stack.pop();

	}

	public boolean hasCycle(){
		return hasCycle;
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
		DirectedCycleMy dc = new DirectedCycleMy(g);
		Out.println(dc);
	}
}
