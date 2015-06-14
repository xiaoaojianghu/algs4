package fundmental.execise;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(ex(6));
		int n = 15;
//		for(int j = 0; j <= 10000; j++){
//			for(int i = j; i > 0; i /=3 )
//				System.out.println( i );
//			System.out.println();
//		}
		
		String s = "hh";
		String s2 = s;
		s2 = "'";
		System.out.println(s);
	}

	public static void test(){
		return;
	}
	public static String ex(int n) {
		
		if(n <= 0){
			return "";
		}
		String s = ex(n-3) + n + ex(n-2) + n;
		return s;
	}

}
