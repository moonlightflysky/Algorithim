package dp;

public class CoinChangeProblem {
	
	public int minCoins(int[] coins, int target){
		
		if (coins == null || coins.length == 0 || target <= 0){
			return -1;
		}
		
		int N = coins.length;
		int[] dp = new int[target + 1];
		
		for (int i = 1; i <= target; i++){
			
			dp[i] = Integer.MAX_VALUE;
			
			for (int j = 0; j < N; j++){
				
				if (coins[j] > i){
					continue;
				}
				
				else{
					
					if (dp[i - coins[j]] != Integer.MAX_VALUE){
						dp[i] = Math.min(dp[i],  dp[i - coins[j]] + 1);
					}
				}
				
			}
			
		}
		
		return dp[target];
		
	}
	
	public static void main(String[] argv){
		
		int[] coins = {1, 2, 5};
		int target = 11;
		
		CoinChangeProblem test = new CoinChangeProblem();
		System.out.println(test.minCoins(coins, target));
		
	}

}
