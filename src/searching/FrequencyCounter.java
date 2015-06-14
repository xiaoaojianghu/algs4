package searching;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FrequencyCounter  {
	/*
	 * 一开始没有写方法,直接在类里面写执行语句. 昨天晚上还找了半天错误,哎...
	 * 2015年6月7日08:32:51
	 */
	public static void main(String[] args) throws Exception{
//		File file = new File("c:\\tinyTale.txt");
		File file = new File("c:\\Tale.TXT");
//		File file = new File("c:\\MFRND10.TXT");
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = in.readLine();
		// Sting[] words = new String[100];
//		SequentialSearchST<String, Integer> set = new SequentialSearchST<String, Integer>();
//		BinarySearchST<String, Integer> set = new BinarySearchST<String, Integer>(100);
//		BST<String, Integer> set = new BST<String, Integer>();
//		BSTmy<String, Integer> set = new BSTmy<String, Integer>();
//		RedBlackBST<String, Integer> set = new RedBlackBST<String, Integer>();
//		SeparateChainingHashST<String, Integer> set = new SeparateChainingHashST<String, Integer>();
		LinearProbingHashST<String, Integer> set = new LinearProbingHashST<String, Integer>();
		
		set.put("s",3);
		set.put("e",3);
		set.put("a",9);
		set.put("r",3);
		set.put("c",3);
		set.put("h",3);
		set.put("x",3);
		set.put("m",3);
		set.put("p",3);
		set.put("l",3);
		set.put("w",3);
		long time = System.currentTimeMillis();
/*		while(line != null){
			String[] words = line.split(" ");
			for(String word : words){
				if(word.equals(""))
					continue;
				Integer value = set.get(word);
				if(value != null){
					set.put(word, ++value);
				} else{
					set.put(word, 1);
				}
			}
			line = in.readLine();
		}*/
//		System.out.printf(" max:%s \n min:%s \n floor:%s", set.max(), set.minRecur(), set.floor("zeal"));
//		System.out.printf(" max:%s \n select:%s \n floor:%s",
//					set.max(), set.select(0), set.floor("zeal"));
		System.out.printf(" rank:%s \n select:\n",
				set.get("a"));
		set.delete("s");
		System.out.println(set.get("a"));
		
//		set.show();
//		set.deleteMy("h");
//		System.out.println();
//		set.show();
//		System.out.println(System.currentTimeMillis() - time);
/*		Iterable q = set.keys("e", "r");
		for(Object o: q){
			System.out.println(o);
		}
		*/
	}
	
	

}