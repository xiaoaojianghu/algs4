package graphs;
import java.util.*;

public class DepthFirstOrder{
	private boolean[] mark;
	private LinkedList<Integer> pre = new LinkedList<Integer>();
	private LinkedList<Integer> post = new LinkedList<Integer>();
	private LinkedList<Integer> reversePost = new LinkedList<Integer>();

	public DepthFirstOrder(Digraph g){
		mark = new boolean[g.V()];
		for(int i = 0; i < g.V(); i++){
			if(!mark[i])
				dfs(g, i);
		}
	}

	private void dfs(Digraph g, int v){
		mark[v] = true;
		pre.offer(v);
		for(int i : g.adj(v))
			if(!mark[i])
				dfs(g, i);
		post.offer(v);
		reversePost.push(v);
	}

	public Iterable<Integer> pre(){
		return pre;
	}

	public Iterable<Integer> post(){
		return post;
	}

	public Iterable<Integer> reversePost(){
		return reversePost;
	}
}