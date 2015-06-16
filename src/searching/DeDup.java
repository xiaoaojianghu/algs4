package searching;

import java.util.*;
import java.io.*;

public class DeDup{
	public static void main(String[] args) throws Exception{
		File f = new File("txt/tinyTale.txt");
		Scanner s = new Scanner(new BufferedReader(new FileReader(f)));
		HashSet<String> set = new HashSet<String>();
		while(s.hasNext()){
			String i = s.next();
			set.add(i);
		}
		s.close();

		System.out.println(set);
	}
}