package graphs;
import java.io.*;
import java.util.*;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.introcs.In;

public class Test{
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(new File("txt/tinyG.txt"));
		Graph g = new Graph(s);
		Out.println(g);
		// new DepthFirstSearch(g, 0);
//		 DepthFirstPaths p = new DepthFirstPaths(g, 0);
		//  Scanner ss = new Scanner(new File("txt/tinyCG.txt"));
		//  In in = new In(ss);
		//  edu.princeton.cs.algs4.Graph gg = new edu.princeton.cs.algs4.Graph(in);
		// BreadthFirstPaths p = new BreadthFirstPaths(g, 0);
		 

		// for(int i = 0; i < g.V(); i++){
		// 	if(p.hasPathTo(i))
		// 		Out.println(0 + " to " + i + ":" + p.pathTo(i));
		// }
		CC cc= new CC(g);
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