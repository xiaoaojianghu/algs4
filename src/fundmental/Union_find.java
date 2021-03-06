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
	//最早版本, 同一个分量值相同 quick find
	public void union1(int p, int q){
		int ip = find1(p);
		int iq = find1(q);
		if(ip == iq)
			return;
		for(int i = 0; i < id.length; i++){
			if(id[i] == ip)
				id[i] = iq;
		}
		N--;
	}

	public int find1(int p){
		return id[p];
	}

	//同一个分量用一棵树表示 quick union
	public void union2(int p, int q){
		int rootp = find2(p);
		int rootq = find2(q);
		if(rootp == rootq)
			return;
		id[rootp] = rootq;
		N--;
	}


	public int find2(int p){
		int root = p;
		while(root != id[root])
			root = id[root];
		return root;
	}


	public boolean connected(int p, int q){
		return id[p] == id[q];
	}	

	public int count(){
		return N;
	}

	public static void main(String [] args) throws IOException{
//		File f = new File("mediumUF.txt");
//		File f = new File("tinyUF.txt");
		File f = new File("largeUF.txt");

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
			u.union2(p,q);
			s = r.readLine();
		}
		r.close();
		System.out.println("count: " + u.count());
	}
}