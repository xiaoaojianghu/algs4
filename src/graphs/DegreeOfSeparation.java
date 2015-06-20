package graphs;
import java.util.*;
public class DegreeOfSeparation{
	private boolean mark[];
	private Queue<Integer> q;
	private int[] path;
	private SymbolGraph sg;
	private int src, to;
	public DegreeOfSeparation(String s, String t) throws Exception{
			sg = new SymbolGraph("", "/");
			Graph g = sg.G();
			src = sg.index(s);
			to = sg.index(t);
			mark = new boolean[g.V()];
			path = new int[g.V()];
			q = new LinkedList<Integer>();
			bfs(src, to);
	}	

	private void bfs(int src, int to){
		mark[src] = true;
		q.offer(src);
		while(!q.isEmpty()){
			int v = q.poll();
			for(int i : sg.G().adj(v)){
				if(!mark[i]){
					mark[i] = true;
					q.offer(i);
					path[i] = v;
					if(i == to){
						return;
					}
				}
			}
		}
	}

	public String toString(){
		StringBuilder s = new StringBuilder();
		int i = to;
		LinkedList<Integer> sta = new LinkedList<Integer>();
		while(i != src){
			sta.push(i);
			i = path[i];
		}
		sta.push(src);
		for(int t : sta){
			s.append(sg.name(t) + "\n");
		}
		return s.toString();
	}

	public static void main(String[] args) throws Exception{
		DegreeOfSeparation ds = new DegreeOfSeparation("Bacon, Kevin", "Kidman, Nicole");
		Out.println(ds);
	}
}