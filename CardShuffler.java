package inter_array;

import java.util.*;

public class CardShuffler {
	
	public int minStepToRecover(char[] array, int[] shuffle){
		
		if (array == null ||shuffle == null || shuffle.length != array.length){
			return -1;
		}
		
		int N = array.length;
		ArrayList<Integer>[] cycles = (ArrayList<Integer>[])new ArrayList[N];
		int[] len = new int[N];
		int res = 1;
		
		for (int i = 0; i < N; i++){
			cycles[i] = new ArrayList<Integer>();
			int q = shuffle[i];
			while (true){
				cycles[i].add(q);
				if (q == i){
					break;
				}
				
				else{
					q = shuffle[q];
				}
			}
			
			len[i] = cycles[i].size();
			//System.out.println("len" + i + ": " + len[i]);
			
		}
		
		res = len[0];
		
		for (int i = 1; i < N; i++){
			res = lcm(res, len[i]);
		}
		
		return res;
		
	}
	
	private int gcd(int a, int b){
		
		if (a % b == 0){
			return b;
		}
		
		else{
			return gcd(b, a % b);
		}
		
	}
	
	private int lcm(int a, int b){
		return (a * b) / gcd(a, b);
	}
	
	public static void main(String[] argv){
		
		char[] array = {'a', 'b', 'c', 'd'};
		int[] shuffle = {3, 1, 2, 0};
		
		CardShuffler test = new CardShuffler();
		
		System.out.println(test.minStepToRecover(array, shuffle));
		
	}

}
