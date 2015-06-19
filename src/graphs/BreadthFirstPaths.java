package graphs;
import java.util.*;

public class BreadthFirstPaths{
	private LinkedList<Integer> q = new LinkedList<Integer>();
	private boolean[] mark;
	private int[] paths;
	private int s;
	public BreadthFirstPaths(Graph g, int s){
		mark = new boolean[g.V()];
		paths = new int[g.V()];
		this.s = s;
		bfs(g, s);
	}

	public void bfsBefore(Graph g, int s){
		q.offer(s);
		mark[s] = true;
		while(!q.isEmpty()){
			for(int i : g.adj(q.poll())){
				if(!mark[i]){
					mark[i] = true;
					paths[i] = s;
					q.offer(i);
				}
			}
		}
	}

	//受前面递归的影响, 忘了改s了
	public void bfs(Graph g, int s){
		q.offer(s);
		mark[s] = true;
		while(!q.isEmpty()){
			int st =  q.poll();
			for(int i : g.adj(st)){
				if(!mark[i]){
					mark[i] = true;
					paths[i] = st;
					q.offer(i);
				}
			}
		}
	}
	public boolean hasPathTo(int v){
		return mark[v];
	}

	public Iterable<Integer> pathTo(int v){
		int i = v;

		LinkedList<Integer> stack = new LinkedList<Integer>();
		while(i != s){
			stack.push(i);
			i = paths[i];
		}
		stack.push(s);
		return stack;
	}
}