public class CoinsInALineII{

    public boolean firstWillWin(int[] values) {
	
		if (values == null || values.length == 0){
			return false;
		}
		
		int N = values.length;
		
		if (N <= 2){
			return true;
		}
		
		int[] dp = new int[N];
		
		dp[N - 1] = values[N - 1];
		dp[N - 2] = values[N - 2] + values[N - 1];
		
		for (int i = N - 3; i >= 0; i--){
			dp[i] = Math.max(values[i] - dp[i + 1], values[i] + values[i + 1] - dp[i + 2]);
		}
		
		return dp[0] > 0;
	
    }

}
