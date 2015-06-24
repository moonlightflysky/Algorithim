package common;

import java.util.ArrayList;

public class FactorialCombination{

	public ArrayList<ArrayList<Integer>> factorialCombination(int n){
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		if (n <= 3){
			return res;
		}
		
		ArrayList<Integer> item = new ArrayList<Integer>();
		
		factorHelper(n, 2, item, res);
		
		return res;
	
	}
	
	private void factorHelper(int n, int index, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
	
		if (!item.isEmpty() && n >= index){
			item.add(n);
			res.add(new ArrayList<Integer>(item));
			item.remove(item.size() - 1);
		}
		
		for (int i = index; i * i <=n; i++){
			
			if (n % i == 0){
				item.add(i);
				factorHelper(n / i, i, item, res);
				item.remove(item.size() - 1);
			}
			
		}
	
	}

	
	public static void main(String[] argv){
		
		int n = 28;
		
		FactorialCombination test = new FactorialCombination();
		ArrayList<ArrayList<Integer>> res = test.factorialCombination(n);
		
		System.out.println(res.toString());
		
	}
}
