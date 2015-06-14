package worksapp;

import java.util.Arrays;


public class Game {
	private static int N = 4, M = 4;
	private static int[][] pathA = { 
		{ -1,  4,  5,  1 }, 
		{  2, -1,  2,  4 },
		{  3,  3, -1, -1 }, 
		{  4,  2,  1,  2 } 
	};

	private static int[][] pathB = { 
		{ -1,  4,  5,  1 }, 
		{  2, -1,  2,  4 },
		{  3,  3, -1,  3 }, 
		{  4,  2,  1,  2 } 
	};
	public static void getCol(int [][] path, int leftCol[]){
		for(int i=0; i<N; i++){
			if(path[i][0] == -1){
				leftCol[i] = -1;
				continue;
			}
			int up = leftCol[i];
			for(int j = i; j >= 0; j--){
				if(path[j][0] == -1)
					break;
				up += path[j][0];
			}
			
			int down = leftCol[i];
			for (int j = i; j<N; j++){
				if(path[j][0] == -1)
					break;
				down += path[j][0];
			}
			
			leftCol[i] = up>down? up: down;
		}
	}
	public static int getResult(int path[][]){
		int res[] = new int[N];
		int temp[] = new int[N];
		getCol(path, res);
		
		for(int j=1; j<M; j++){
			for(int i=0; i<N; i++){
				if(path[i][j] == -1){
					temp[i] = -1;
				}else if(res[i] != -1){
					temp[i] = res[i] + path[i][j];
				}else{
					temp[i] = -1;
				}
			}
			System.out.println();
			for(int i:res)
				System.out.print(i + " ");
			//form top
			for(int i=0; i<N; i++){
				if(temp[i] == -1)
					continue;
				int down = -1;
				if(i == N-1){
					if(  temp[0] != -1)
						down = 0;
				}
					
				else
					down = temp[i+1] ;
				
				if (down != -1 && down + path[i][j]> res[i])
					res[i] = down + path[i][j];
			}
			
			System.out.println();

			for(int i:res)
				System.out.print(i + " ");


			//form bottom
			for(int i=N-1; i>=0; i--){
				if(temp[i] == -1)
					continue;
				int down = -1;
				if(i == N-1 && temp[0] != -1)
					down = 0;
				else
					down = temp[i+1] ;
				
				if (down != -1 && down + path[i][j]> res[i])
					res[i] = down + path[i][j];
			}
			System.out.println();

			for(int i:res)
				System.out.print(i + " ");
			System.out.println();

		}
		
		int result = -1;
		for(int i=0; i<N; i++){
			if(res[i] > result)
				result = res[i];
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(getResult(pathB));
	}
	
}
