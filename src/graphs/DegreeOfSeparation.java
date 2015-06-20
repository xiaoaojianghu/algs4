package graphs;
import java.util.*;
public class DegreeOfSeparation{
	private boolean mark[];
	private Queue<Integer> q;
	private LinkedList<Integer> path;
	private SymbolGraph sg;
	public DegreeOfSeparation(String src, String to) throws Exception{
			sg = new SymbolGraph("", "/");
			Graph g = sg.G();
			int src_i = sg.index(src);
			int to_i = sg.index(to);
			mark = new boolean[g.V()];
			path = new LinkedList<Integer>();
			q = new LinkedList<Integer>();
			bfs(src_i, to_i);
	}	

	private void bfs(int src, int to){
		mark[src] = true;
		q.offer(src);
		while(!q.isEmpty()){
			int v = q.poll();
//			path.add(v);
			for(int i : sg.G().adj(v)){
				if(!mark[i]){
					mark[i] = true;
					q.offer(i);
					if(i == to){
						path.add(i);
						return;
					}
				}
			}
		}
	}

	public String toString(){
		StringBuilder s = new StringBuilder();
		for(int i : path){
			s.append(sg.name(i) + "\n");
		}
		return s.toString();
	}

	public static void main(String[] args) throws Exception{
		DegreeOfSeparation ds = new DegreeOfSeparation("Bacon, Kevin", "Kidman, Nicole");
		Out.println(ds);
	}
}