package fundmental;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Union_find{
	private int[] id;
	private int N;
	public Union_find(int n){
		id = new int[n];
		for(int i = 0; i < n; i++)
			id[i] = i;
		N = n;
	}

	public void union(int p, int q){
		int ip = find(p);
		int iq = find(q);
		if(ip == iq)
			return;
		for(int i = 0; i < id.length; i++){
			if(id[i] == ip)
				id[i] = iq;
		}
		N--;
	}

	public int find(int p){
		return id[p];
	}

	public boolean connected(int p, int q){
		return id[p] == id[q];
	}	

	public int count(){
		return N;
	}

	public static void main(String [] args) throws IOException{
		File f = new File("mediumUF.txt");
//		File f = new File("tinyUF.txt");
		BufferedReader r = new BufferedReader(new FileReader(f));
		String s = r.readLine();
		Union_find u = new Union_find(Integer.valueOf(s));
		s = r.readLine();
		String[] ints;
		while(s != null){
			ints =  s.split(" ");
			int p = Integer.valueOf(ints[0]);
			int q = Integer.valueOf(ints[1]);
			System.out.println( p + " " + q);
			u.union(p,q);
			s = r.readLine();
		}
		r.close();
		System.out.println("count: " + u.count());
	}
}