package searching;
import java.util.*;
import java.io.*;

public class LookUpIndexMy{
	public static void mainMy(String [] args) throws IOException{
		HashMap<String, Set<String>> index = new HashMap<String, Set<String>>();
		HashMap<String, String> rindex = new HashMap<String, String>();
		BufferedReader b = new BufferedReader(new FileReader(new File("txt/aminoI.txt")));
		String s = b.readLine();
		while(s != null){
			String[] sa = s.split(",");
			Set<String> valSet = index.get(sa[0]);
			if( valSet == null)
				 valSet = new HashSet<String>();
			 for(int i = 1; i < sa.length; i++){
					valSet.add(sa[i]);
					rindex.put(sa[i], sa[0]);
			}
			index.put(sa[0], valSet);
			s = b.readLine();
		}
		b.close();
		Scanner sca = new Scanner(System.in);
		Out.println(index.get(sca.next()));
		Out.println(rindex.get(sca.next()));
		sca.close();
	}
}