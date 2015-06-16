public class MaximumSubarrayIII{
	
    public int maxSubArray(ArrayList<Integer> nums, int k) {
	
		if (nums == null || nums.size() < k){
			return 0;
		}
		
		int N = nums.size();
		
		int[][] dp = new int[N + 1][k + 1];
		
		for (int j = 1; j <= k; j++){
			for (int i = j; i <= N; i++){
				
				dp[i][j] = Integer.MIN_VALUE;
				
				int endMax = 0;
				int max = Integer.MIN_VALUE;
				
				for (int p = i - 1; p >= j - 1; p--){
					endMax = Math.max(nums.get(p), endMax + nums.get(p));
					max = Math.max(max, endMax);
					
					dp[i][j] = Math.max(dp[p][j - 1] + max, dp[i][j]);
					
				}
			
			}
		}
		
		return dp[N][k];
    }

}
