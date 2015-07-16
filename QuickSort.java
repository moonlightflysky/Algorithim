package common;

import java.util.Random;

public class QuickSort{

	public void quickSort(int[] nums){
	
		shuffle(nums);
		int N = nums.length;
		
		quickSort(nums, 0, N - 1);
		
		
	}
	
	
	private void quickSort(int[] nums, int lo, int hi){
		
		if (lo >= hi){
			return;
		}
		
		int j = partition(nums, lo, hi);
		
		quickSort(nums, lo, j - 1);
		quickSort(nums, j + 1, hi);
		
		
		
	}
	
	private int partition(int[] nums, int lo, int hi){
		
		int i = lo;
		int j = hi + 1;
		
		int pv = nums[lo];
		
		while(true){
			
			while (nums[++i] < pv){
				if (i == hi)	break;
			}
			
			while (nums[--j] > pv){
				if (j == lo)	break;
			}
			
			if (i >= j){
				break;
			}
			
			exch(nums, i, j);
		}
		
		exch(nums, lo, j);
		
		return j;
	
	}
	
	public int quickSelect(int[] nums, int k){
		
		int N = nums.length;
		
		int lo = 0;
		int hi = N - 1;
		
		while (lo < hi){
			
			int j = partition(nums, lo, hi);
			
			if (j == k){
				return nums[k];
			}
			
			if (j < k){
				lo = j + 1;
			}
			
			else{
				hi = j - 1;
			}
			
		}
		
		return nums[k];
		
	}
	
	public void threeWayQuickSort(int[] nums, int lo, int hi){
		
		if (lo >= hi){
			return;
		}
		
		int lt = lo;
		int gt = hi;
		
		int pv = nums[lo];
		int i = lo + 1;
		
		while (i <= gt){
			
			if (nums[i] < pv)	exch(nums, i++, lt++);
			else if (nums[i] > pv)	exch(nums, i, gt--);
			else	i++;
			
		}
		
		threeWayQuickSort(nums, lo, lt - 1);
		threeWayQuickSort(nums, gt + 1, hi);
	
	}
	
	
	private void shuffle(int[] nums){
		
		Random rand = new Random();
		int N = nums.length;
		
		for (int i = 1; i < N; i++){
			int j = rand.nextInt(i + 1);
			exch(nums, i, j);
		}
	
	}
	
	private void exch(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	
}
