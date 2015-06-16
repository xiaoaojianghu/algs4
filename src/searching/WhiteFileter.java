package searching;

import java.util.*;
import java.io.*;
public class WhiteFileter{
	public static void main(String[] args) throws IOException{
		File white = new File("txt/list.txt");
		Scanner s = new Scanner(new BufferedReader(new FileReader(white)));
		HashSet<String> whtList = new HashSet<String>();
		while(s.hasNext())
			whtList.add(s.next());
		s.close();

		Scanner s2 = new Scanner(new BufferedReader(new FileReader(new File("txt/tinyTale.txt"))));
		while(s2.hasNext()){
			String i = s2.next();
			if(whtList.contains(i))
				Out.println(i);		
		}
		s2.close();
	}
}