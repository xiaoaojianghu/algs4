package sorting;

public class TestPQ{
	public static void main( String[] args){
		MaxPQmy<String> q = new MaxPQmy<String>(100);
//		MaxPQ<String> q = new MaxPQ<String>(100);
		String s = "53q5twe";
		String[] a = s.split("");
		for(String i : a){
			if(i.equals(""))
				continue;
			q.insert(i);
		}
		while(!q.isEmpty()){
			System.out.print(q.delMax() + " ");
		}
	}
}