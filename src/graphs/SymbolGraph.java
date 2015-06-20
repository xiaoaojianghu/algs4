package graphs;
import java.util.*;
import java.io.*;


public class SymbolGraph{
	private String[] sym;
	private HashMap<String, Integer> map;
	private Graph g;

	public SymbolGraph(String filename, String delim) throws Exception{
		Scanner s = new Scanner(new File("txt/movies.txt"));
		int count = 0;
		map = new  HashMap<String, Integer>();
		String line;
		while(s.hasNextLine()){
			 line = s.nextLine();
			 String[] a = line.split(delim);
			 for(String i : a){
			 	map.put(i, count);
			 	count++;
			 }
		}
		sym = new String[count];
		g = new Graph(count);
		for(String i : map.keySet()){
			sym[map.get(i)] = i;
		}
//		s.close();
		s = new Scanner(new File("txt/movies.txt"));

		while(s.hasNextLine()){
			line = s.nextLine();
			String[] a = line.split(delim);
			int src = map.get(a[0]);
			for(String i : a){
				int to = map.get(i);
				g.addEdge(src, to);
			}
		}
		s.close();

	}	

	public boolean contains(String key){
		return map.containsKey(key);
	}

	public int index(String key){
		return map.get(key);
	}

	public Graph G(){
		return g;
	}
	
	public String name(int i){
		return sym[i];
	}
	public static void main(String[] args) throws Exception{
        String filename  = "";
        String delimiter = "/";
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph g = sg.G();
        String name = "Jayne, Billy";
        String movie = "'Breaker' Morant (1980)";
        Iterable<Integer> list = g.adj(sg.index(name));
        for(int i : list){
        	System.out.print(sg.name(i) + "||||	");
	    }
        Iterable<Integer> list2 = g.adj(sg.index(movie));
        System.out.println();
        for(int i : list2){
        	System.out.print(sg.name(i) + " ");
	    }
    }
}