package graphs;
import java.util.*;
public class DepthFirstPaths{
	private Graph g;
	private int s;
	private boolean mark[];
	private int paths[];
	public DepthFirstPaths(Graph g, int s){
		this.g = g;
		this.s = s;
		mark = new boolean[g.V()];
		paths = new int[g.V()];
		for(int i = 0; i < paths.length; i++)
			paths[i] = -1;
		dfs(g, s);
		Out.println(Arrays.asList(paths));
	}

	public void dfs(Graph g, int s){
		mark[s] = true;
		for(int i : g.adj(s)){
			if(!mark[i]){
				paths[i] = s;
				dfs(g, i);
			}
		}

	}

	public boolean hasPathTo(int v){
		return mark[v];
	}

	public Iterable<Integer> pathTo(int v){
		LinkedList li = new LinkedList();
		int i = v;
		while(i != s){
			li.push(i);
			i = paths[i];
		}
		li.push(s);
		return li;
	}
}