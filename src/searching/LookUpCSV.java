package searching;

import java.util.*;
import java.io.*;

public class LookUpCSV{
	public static void main(String[] args) throws IOException{
		Scanner s = new Scanner(System.in);
		Out.println("输入k, v field:");
//		String test = s.nextLine();
		int k = s.nextInt();
		int v = s.nextInt();
		BufferedReader b = new BufferedReader(new FileReader(new File("txt/amino.csv")));
		String i = b.readLine();
		HashMap<String, String> map = new HashMap<String, String>();
		while(i != null){
			String[] as = i.split(",");
			map.put(as[k], as[v]);
			i = b.readLine();
		}
		b.close();
		Out.println("输入key:");
		i = s.next();
		Out.println(map.get(i));
		s.close();
	}
}