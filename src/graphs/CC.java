package graphs;

public class CC{
	private boolean mark[];
	private int[] id;
	private int count;
	public CC(Graph g){
		int c = g.V();
		mark = new boolean[c];
		id = new int[c];
		for(int i = 0; i < c; i++){
			id[i] = -1;
		}
		count = 0;
		dfs(g);
	}


	private void dfs(Graph g){
		for(int i = 0; i < mark.length; i++){
			if(!mark[i]){
				count++;
				id[i] = count;
				dfs(g, i);
			}
		}
	}

	public void dfs(Graph g, int s){
		mark[s] = true;
		for(int i : g.adj(s)){
			if(!mark[i]){
				id[i] = id[s];
				dfs(g, i);
			}
		}
	}
	public boolean connected(int v, int w){
		return id[v] == id[w];
	}

	public int count(){
		return count;
	}

	public int id(int v){
		return id[v];
	}
}