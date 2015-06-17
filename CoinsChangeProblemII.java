package common;

public class CoinsChangeProblemII{
	
	public int count(int[] coins, int target){
	
		if (coins == null || coins.length == 0){
			return 0;
		}
		
		int N = coins.length;
		
		int[] dp = new int[target + 1];
		dp[0] = 1;
		
		for (int i = 1; i <= target; i++){
			for (int j = 0; j < N; j++){
				if (coins[j] > i){
					continue;
				}
				
				dp[i] += dp[i - coins[j]];
			}
		}
		
		return dp[target];
		
	}
	
	public static void main(String[] argv){
		
		int[] coins = {1, 2, 5};
		int target = 5;
		
		CoinsChangeProblemII test = new CoinsChangeProblemII();
		System.out.println(test.count(coins, target));
		
	}

}
