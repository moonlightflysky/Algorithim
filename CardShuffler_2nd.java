package inter_array;

import java.util.Arrays;

public class CardShuffler_2nd {
	
	public int minStepToRecover(char[] array, int[] shuffle){
		
		if (array == null || shuffle == null || array.length != shuffle.length){
			return -1;
		}
		
		int N = array.length;
		
		int[] count = new int[N];
		Arrays.fill(count, 1);
		for (int i = 0; i < N; i++){
			int p = shuffle[i];
			while (p != i){
				p = shuffle[p];
				count[i]++;
			}
		}
		
		int res = count[0];
		
		for (int i = 1; i < N; i++){
			res = lcm(res, count[i]);
		}
		
		return res;
	}
	
	private int GCD(int a, int b){
		
		if (a % b == 0){
			return b;
		}
		
		else{
			return GCD(b, a % b);
		}
	}
	
	private int lcm(int a, int b){
		return (a * b) / (GCD(a, b));
	}
	
	public static void main(String[] argv){
		
		char[] array = {'a', 'b', 'c', 'd'};
		int[] shuffle = {3, 1, 2, 0};
		
		CardShuffler_2nd test = new CardShuffler_2nd();
		
		System.out.println(test.minStepToRecover(array, shuffle));
		
	}

}
