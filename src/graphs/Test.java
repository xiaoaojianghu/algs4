package graphs;
import java.io.*;
import java.util.*;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.introcs.In;

public class Test{
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(new File("txt/tinyCG.txt"));
		Graph g = new Graph(s);
		Out.println(g);
		// new DepthFirstSearch(g, 0);
		 DepthFirstPaths p = new DepthFirstPaths(g, 0);
		 Scanner ss = new Scanner(new File("txt/tinyCG.txt"));
		 In in = new In(ss);
		 edu.princeton.cs.algs4.Graph gg = new edu.princeton.cs.algs4.Graph(in);
//		BreadthFirstPaths p = new BreadthFirstPaths(g, 0);
		 
		Out.println(p.pathTo(4));
		for(int i = 0; i < g.V(); i++){
			if(p.hasPathTo(i))
				Out.println(0 + " to " + i + ":" + p.pathTo(i));
		}
	}
}