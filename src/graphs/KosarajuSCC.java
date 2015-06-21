package graphs;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KosarajuSCC{
	private boolean mark[];
	private int[] id;
	private int count; 
	public KosarajuSCC(Digraph g){
		mark = new boolean[g.V()];
		id = new int[g.V()];
		DepthFirstOrder order = new DepthFirstOrder(g.reverse());
		count = 0;
		for(int i : order.reversePost()){
			if(!mark[i]){
				dfs(g, i);
				count++;
			}
		}		
	}

	private void dfs(Digraph g, int s){
		mark[s] = true;
		id[s] = count;
		for(int i : g.adj(s))
			if(!mark[i]){
				dfs(g, i);
			}
	}

	public int count(){
		return count;
	}

	public int id(int v){
		return id[v];
	}

	public boolean stronglyConnected(int v, int w){
		return id[v] == id[w];
	}

	public static void main(String[] args) throws Exception{
		Digraph g = new Digraph(new Scanner(new File("txt/tinyDG.txt")));
		KosarajuSCC cc = new KosarajuSCC(g);
		int count = cc.count();
		HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

		for(int i = 0; i < g.V(); i++){
			int id = cc.id(i);
			Set<Integer> set = map.get(id);
			if(set == null){
				set = new HashSet<Integer>();
			}
			set.add(i);
			map.put(id, set);
		}

		Out.println(count + "\n" + map); 	
	}
}