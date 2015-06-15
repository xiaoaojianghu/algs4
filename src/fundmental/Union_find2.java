//加权quick-union, 小树总是连到大树上
package fundmental;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Union_find2{
	private int[] id;
	private int[] sz;
	private int N;
	public Union_find2(int n){
		id = new int[n];
		sz = new int[n];
		for(int i = 0; i < n; i++){
			id[i] = i;
			sz[i] = 1;
		}
		N = n;
	}
	
	public void union(int p, int q){
		int rootp = find(p);
		int rootq = find(q);
		if(rootp == rootq)
			return;
		if(sz[rootp] > sz[rootq]){
			id[rootq] = rootp;
			sz[rootp] += sz[rootq];
		} else {
			id[rootp] = rootq;
			sz[rootq] += sz[rootp];
		}
		N--;
	}

	public int find(int p){
		while(p != id[p])
			p = id[p];
		return p;
	}

	
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}	

	public int count(){
		return N;
	}

	public static void main(String [] args) throws IOException{
//		File f = new File("mediumUF.txt");
		File f = new File("largeUF.txt");
		BufferedReader r = new BufferedReader(new FileReader(f));
		String s = r.readLine();
		Union_find2 u = new Union_find2(Integer.valueOf(s));
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