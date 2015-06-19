package graphs;

public class DepthFirstSearch{
	private boolean marked[];
	private int count;

	public DepthFirstSearch(Graph g, int s){
		marked = new boolean[g.V()];
		dfs(g, s);
	}

	public void dfs(Graph g, int s){
		marked[s] = true;
		System.out.println(s);
		count++;
		for(int i : g.adj(s)){
			if(!marked[i])
				dfs(g, i);
		}
	}

	public int count(){
		return count;
	}

	public boolean marked(int v){
		return marked[v];
	}
}