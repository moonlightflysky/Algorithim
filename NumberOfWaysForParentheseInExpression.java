public class NumberOfWaysForParentheseInExpression {
	
	public int countWays(String exp, boolean result){
		
		if (exp == null || exp.length() == 0){
			return 0;
		}
		
		int length = exp.length();
		int N = length / 2 + 1;
		
		int[][] T = new int[N][N];
		int[][] F = new int[N][N];
		
		for (int i = 0; i < N; i++){
			if (exp.charAt(2 * i) =='0'){
				F[i][i] = 1;
			}
			
			else{
				T[i][i] = 1;
			}
		}
		
		for (int d = 1; d < N; d++){
			for (int i = 0; i < N - d; i++){
				for (int j = i + 1; j <= i + d; j++){
					if (exp.charAt(2 * j - 1) == '&'){
						T[i][i + d] += T[i][j - 1] * T[j][i + d];
						F[i][i + d] += (T[i][j - 1] + F[i][j - 1]) * (T[j][i + d] + F[j][i + d]) - T[i][j - 1] * T[j][i + d];
					}
					
					else if (exp.charAt(2 * j - 1) == '|'){
						T[i][i + d] += (T[i][j - 1] + F[i][j - 1]) * (T[j][i + d] + F[j][i + d]) - F[i][j - 1] * F[j][i + d];
						F[i][i + d] = F[i][j - 1] * F[j][i + d];
					}
					
					else{// == '^'
						T[i][i + d]  = T[i][j - 1] * F[j][i + d] + F[i][j - 1] * T[j][i + d];
						F[i][i + d]  = T[i][j - 1] * T[j][i + d] + F[i][j - 1] * F[j][i + d];
					}
					
					
				}
			}
		}
		
		if (result){
			return T[0][N - 1];
		}
		
		else{
			return F[0][N - 1];
		}
		
	}
	
