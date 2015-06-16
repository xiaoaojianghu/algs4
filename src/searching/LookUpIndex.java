package searching;
import java.io.*;
import java.util.Scanner;

import fundmental.Queue;

public class LookUpIndex{
	public static void main(String [] args) throws IOException{
		BSTmy<String, Queue<String>> index = new BSTmy<String, Queue<String>>();
		BSTmy<String, Queue<String>> rindex = new BSTmy<String, Queue<String>>();
		BufferedReader b = new BufferedReader(new FileReader(new File("txt/movies.txt")));
		String line = b.readLine();
		while(line != null){
			String[] s = line.split("/");
			//我的实现
/*			if(!index.contains(s[0]))
				index.put(s[0], new Queue<String>());
			Queue<String> q = index.get(s[0]);
			for(int i = 1; i < s.length; i++){
				if(!rindex.contains(s[i]))
					rindex.put(s[i], new Queue<String>());
				 rindex.get(s[i]).enqueue(s[0]);
				 q.enqueue(s[i]);
			}
			index.put(s[0], q);*/
			
			///////////////////////////
			//书上这个实现好慢,
			/*
			 * 按顺序存入,我用的是BST,从而变成了顺序查找, index get太多了
			 */
			for(int i = 1; i < s.length; i++){
				if(!index.contains(s[0]))
					index.put(s[0], new Queue<String>());
				if(!rindex.contains(s[i]))
					rindex.put(s[i], new Queue<String>());
				index.get(s[0]).enqueue(s[i]);
				rindex.get(s[i]).enqueue(s[0]);
			}
			
			/***********/
			line = b.readLine();//昨天这个忘了,调了半天.表现就是运行结束不了
		}
		b.close();
		Scanner scan = new Scanner(System.in);
		String key = scan.nextLine();
		Out.println(index.get(key));
		key = scan.nextLine();
		Out.println(rindex.get(key));
		scan.close();

	}
}