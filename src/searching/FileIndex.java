package searching;
import java.util.*;
import java.io.*;


public class FileIndex{
	public static void main(String[] args) throws IOException{
		TreeMap<String, Set<String>> index = new TreeMap<String, Set<String>>();
		for(int i = 1; i <= 4; i++){
			File f = new File("txt/ex" + i + ".txt");
			Scanner s = new Scanner(f);
			while(s.hasNext()){
				String str = s.next();
				Set<String> set = index.get(str);
				if(set == null)
					set = new HashSet<String>();
				set.add(f.getName());
				index.put(str, set);
			}
			s.close();
		}
		Out.println(index);

	}
}