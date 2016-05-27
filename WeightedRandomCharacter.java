package uber;

import java.util.*;

public class WeightedRandomCharacters {
	
	public char getRandomWithWeights(char[] c, int[] weights){
		
		if (c == null || weights == null || c.length != weights.length){
			return ' ';
		}
		
		int N = c.length;
		int[] sumWeights = new int[N];
		sumWeights[0] = weights[0];
		
		for (int i = 1; i < N; i++){
			sumWeights[i] = sumWeights[i - 1] + weights[i];
		}
		
		
		Random rand = new Random();
		
		int r = rand.nextInt(sumWeights[N - 1]) + 1;
		//int r = 6;
		System.out.println("r == " + r);
		
		int index = binarySearch(sumWeights, r, 0, N - 1);
		System.out.println("index == " + index);
		
		return c[index];
		
	}
	
	private int binarySearch(int[] sumWeights, int r, int lo, int hi){
		
		while(lo <= hi){
			
			int mid = lo + (hi - lo)/2;
			
			if (sumWeights[mid] == r){
				return mid;
			}
			
			else if (sumWeights[mid] < r){
				lo = mid + 1;
			}
			
			else{
				hi = mid - 1;
			}
			
		}
		
		return lo;
		
	}
	
	public static void main(String[] argv){
		
		char[] c = {'a', 'b', 'c'};
		int[] weights = {1, 2, 3};
		
		WeightedRandomCharacters test = new WeightedRandomCharacters();
		int countA = 0, countB = 0, countC = 0;
		
		for (int i = 0; i < 1000; i++){
			char res = test.getRandomWithWeights(c, weights);
			if (res == 'a'){
				countA++;
			}
			
			else if (res == 'b'){
				countB++;
			}
			
			else if (res == 'c'){
				countC++;
			}
			
			else{
				System.out.println("wrong");
				break;
			}
		}
		
		System.out.println("count a: " + countA);
		System.out.println("count b: " + countB);
		System.out.println("count c: " + countC);
		
	}

}
