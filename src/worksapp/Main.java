package worksapp;

import java.util.Scanner;


public class Main {
	static int MIN = -2;
	static int N, M;
	static Scanner scanner = new Scanner(System.in);
	
	private static int[][] boardA = { 
		{ -1,  4,  5,  1 }, 
		{  2, -1,  2,  4 },
		{  3,  3, -1, -1 }, 
		{  4,  2,  1,  2 } 
	};
	
	static void getMatrix(int[][] path){
		String[] line;
		int n = 0;
		while (scanner.hasNextLine()) {
			line = scanner.nextLine().split(" ");
			for(int i = 0; i < M; i++){
				path[n][i] = Integer.parseInt(line[i]);
			}
			n++;
			if(n == N)
				break;
		}
	}

	static void solve() {
		
		String[] s = scanner.nextLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int[][] board = new int[N][M];
		getMatrix(board);
		
		int[][][] dist = new int[N][M][3];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				for(int k = 0; k < 3; k++)
					dist[i][j][k] = -1;
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.printf("(%d,%d,%d) ", get_dist(board, dist, i, j, 0), get_dist(board, dist, i, j, 1), get_dist(board, dist, i, j, 2));
//			}
//			System.out.printf("\n");
//		}

		// compute the possible start points
		int[][] possible = new int[N][M];
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				if (j == 0) possible[i][j] = board[i][j] != -1 ? 1 : 0;
				else {
					if (board[i][j] == -1) { possible[i][j] = 0; continue; }

					if ( i == 0) possible[i][j] = possible[i][j-1];
					else possible[i][j] = max(possible[i][j-1], possible[i-1][j]);

					if (i == N-1) {
						possible[i][j] = max(possible[i][j], possible[0][j]);
						possible[0][j] = max(possible[i][j], possible[0][j]);
					}
				}
			}
		}

		int ans = 0;
		// enumerate all the possible start points
		for (int i = 0; i < N; i++) {
			if (possible[i][0] != 0) {
				ans = max(ans, get_dist(board, dist, i, 0, 0));
				ans = max(ans, get_dist(board, dist, i, 0, 1));
				ans = max(ans, get_dist(board, dist, i, 0, 2));
			}
		}
		for (int j = 1; j < M-1; j++) {
			if (possible[0][j] != 0) {
				ans = max(ans, get_dist(board, dist, N-1, j, 0));
				ans = max(ans, get_dist(board, dist, N-1, j, 1));
				ans = max(ans, get_dist(board, dist, N-1, j, 2));
			}
			if (possible[N-1][j] != 0) {
				ans = max(ans, get_dist(board, dist, 0, j, 0));
				ans = max(ans, get_dist(board, dist, 0, j, 1));
				ans = max(ans, get_dist(board, dist, 0, j, 2));
			}
		}
		System.out.printf("%d\n", ans);
	}

	static int get_dist(int [][] board, int [][][]dist, int i, int j, int d) {
//		printf("%d,%d,%d\n", i, j, d);
		if (board[i][j] == -1) return MIN;
		if (dist[i][j][d] != -1) return dist[i][j][d];
		// direction
		int direction[][] = {
				{-1, 0}, // up
				{0, 1}, // right
				{1, 0}, // down
		};
		int n = board.length;
		int m = board[0].length;
		int next_i = direction[d][0] + i;
		int next_j = direction[d][1] + j;

		if (next_j == m-1 && (next_i == -1 || next_i == n)) return dist[i][j][d] = board[i][j];
		if (next_j == m) return dist[i][j][d] = board[i][j];

		if (!(next_i < n && next_i >= 0 && next_j < m && next_j >= 0)) return dist[i][j][d] = MIN;

		int ans = 0;
		for (int next_d = 0; next_d < 3; next_d++) {
			if (d == 0 && next_d == 2) continue;
			if (d == 2 && next_d == 0) continue;
			ans = max(ans, get_dist(board, dist, (next_i+n)%n, (next_j+m)%m, next_d) + 1 * board[i][j]);
		}

//		if (next_i < n && next_i >= 0 && next_j < m && next_j >= 0) ans += board[i][j];
		return dist[i][j][d] = ans;
	}
	static int max(int a, int b) {
		return a > b ? a : b;
	}
	public static void main(String[] args) {
		solve();
	}

}
