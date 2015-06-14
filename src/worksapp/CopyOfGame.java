package worksapp;


public class CopyOfGame {
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
		int leftCol[] = new int[N];
		getCol(path, leftCol);
		
		for(int j=1; j<M; j++){
			for(int i=0; i<N; i++){
				if(path[i][j] != -1){
					leftCol[i] = -1;
				}else{
					leftCol[i] += path[i][j];
				}
			}
			
			//form top
			for(int i=0; i<N; i++){
				if(leftCol[i] == -1)
					continue;
				int top = -1;
				if(i == 0)
					top = 0;
				else
					top = leftCol[i-1] + path[i][j];
				
				if (top > leftCol[i])
					leftCol[i] = top;
			}
			
			//form bottom
			for(int i=N-1; i>0; i--){
				if(leftCol[i] == -1)
					continue;
				int down = -1;
				if(i == N-1)
					down = 0;
				else
					down = leftCol[i+1] + path[i][j];
				
				if (down > leftCol[i])
					leftCol[i] = down;
			}
		}
		
		int result = -1;
		for(int i=0; i<N; i++){
			if(leftCol[i] > result)
				result = leftCol[i];
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(getResult(pathB));
	}
	
}
