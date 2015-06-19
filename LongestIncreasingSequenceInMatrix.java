package interview;

public class LongestIncreasingSequenceInMatrix {
	
	public int longestIncreasingSequenceInMatrix(int[][] matrix){
	
		if (matrix == null || matrix.length == 0){
			return 0;
		}
		
		int M = matrix.length;
		int N = matrix[0].length;
		int maxLen = 0;
		
		int[][] dp = new int[M][N];
		
		for (int i = 0; i < M; i++){
			for (int j = 0; j < N; j++){
				if (dp[i][j] == 0){
					maxLen = Math.max(maxLen, findHelper(matrix, i, j, dp));
				}
				
			}
		}
		
		return maxLen;
	}
	
	private int findHelper(int[][] matrix, int i, int j, int[][] dp){
		
		int M = matrix.length;
		int N = matrix[0].length;
		
		if (dp[i][j] != 0){
			return dp[i][j];
		}
		
		int up = 0, down = 0, left = 0, right = 0;
		
		if (i < M - 1 && matrix[i + 1][j] == matrix[i][j] + 1){
			up = findHelper(matrix, i + 1, j, dp);
		}
		if (i > 0 && matrix[i - 1][j] == matrix[i][j] + 1){
			down = findHelper(matrix, i - 1, j, dp);
		}
		if (j > 0 && matrix[i][j - 1] == matrix[i][j] + 1){
			left = findHelper(matrix, i, j - 1, dp);
		}
		if (j < N - 1 && matrix[i][j + 1] == matrix[i][j] + 1 ){
			right = findHelper(matrix, i, j + 1, dp);
		}
		
		dp[i][j] = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
		return dp[i][j];
		
	}
}
