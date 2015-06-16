public class MinimumAdjustmentCost{
	
	public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
	
		if (A == null || A.size() == 0){
			return 0;
		}
		
		int N = A.size();
		
		int[][] dp = new int[N][101];
		int res = Integer.MAX_VALUE;
		
		for (int j = 1; j <= 100; j++){
			dp[0][j] = Math.abs(A.get(0) - j);
		}
		
		for (int i = 1; i < N; i++){
			
			for (int j = 1; j <= 100; j++){
			
				dp[i][j] = Integer.MAX_VALUE;
				
				int curDiff = Math.abs(A.get(i) - j);
				
				for (int k = 1; k <= 100; k++){
					
					if (Math.abs(k - j) > target){
						continue;
					}
					
					dp[i][j] = Math.min(dp[i - 1][k] + curDiff, dp[i][j]);
				}
			}
			
		}
		
		for (int j = 1; j <= 100; j++){
			res = Math.min(res, dp[N - 1][j])
		}
		
		return res;
		
    }

}
