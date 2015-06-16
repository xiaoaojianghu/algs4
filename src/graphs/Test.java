package graphs;
import java.io.*;
import java.util.*;

public class Test{
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(new File("txt/tinyG.txt"));
		Graph g = new Graph(s);
		Out.println(g);
	}
}