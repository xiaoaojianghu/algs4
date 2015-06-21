package graphs;
import java.util.*;

public class Topological{
	private Iterable<Integer> list;
	private boolean dag;
	public Topological(SymbolDigraph g){
		list = new LinkedList<Integer>();
		DirectedCycle cycle = new DirectedCycle(g.G());
		dag = cycle.hasCycle();
		if(dag){
			DepthFirstOrder order = new DepthFirstOrder(g.G());
			list = order.reversePost();
		}
	}

	public boolean isDAG(){
		return dag;
	}

	public Iterable<Integer> order(){
		return list;
	}

	public static void main(String[] args) throws Exception{
		SymbolDigraph g = new SymbolDigraph("txt/jobs.txt", "/");
		Topological t = new Topological(g);
		Out.println(t.order());
		for(int i : t.order())
			Out.println(g.name(i));
	}
}