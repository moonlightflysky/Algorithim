package chapter18;

public class Napsack_DP {
	
	public class Result{
		
		int val;
		boolean[] taken;
		
	}
	
	public Result maxValue(int[] v, int[] w, int aw){
		
		if (v == null || w == null || v.length != w.length || aw <= 0){
			return null;
		}
		
		int N = v.length;
		
		int[][] dp = new int[N + 1][aw + 1];
		boolean [][] sol = new boolean[N + 1][aw + 1];
		
		for (int i = 1; i <= N; i++){
			for (int j = 1; j <= aw; j++){
				
				int option1 = dp[i - 1][j];
				int option2 = Integer.MIN_VALUE;
				
				if (w[i - 1] <= j){
					option2 = dp[i - 1][j - w[i - 1]] + v[i - 1];
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
				}
				
				else{
					dp[i][j] = dp[i - 1][j];
				}
				
				if (option2 > option1){
					sol[i][j] = true;
				}
				
			}
		}
		
		boolean [] taken = new boolean[N];
		
		for (int ind = N, weight = aw; ind > 0; ind--){
			
			if (sol[ind][weight] == true){
				taken[ind - 1] = true;
				weight -= w[ind - 1];
			}
			else{
				taken[ind - 1] = false;
			}
			
		}
		
		Result res = new Result();
		res.val = dp[N][aw];
		res.taken = taken;
		
		return res;
		
	}
	
	public static void main(String[] argv){
		
		int[] v = {874, 620, 345, 369, 360, 470};
		int[] w = {580, 1616, 1906, 1942, 50, 294};
		int aw = 2000;
		
		Napsack_DP test = new Napsack_DP();
		Result res = test.maxValue(v, w, aw);
		int N = v.length;
		
        System.out.println("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "take");
        for (int n = 0; n < N; n++) {
            System.out.println(n + "\t" + v[n] + "\t" + w[n] + "\t" + res.taken[n]);
        }
		
		
	}

}
