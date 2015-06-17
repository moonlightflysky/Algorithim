package common;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class KthClosestToMedian{
	
	public class CloseToMedian implements Comparator<Integer>{
		
		int median;
		
		public CloseToMedian(int median){
			this.median = median;
		}
		
		public int compare(Integer a, Integer b){
			return Math.abs(a - median) - Math.abs(b - median);
		}
		
		
	}
	
	public ArrayList<Integer> getKthClosestToMedian(int[] nums, int k){
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		if (nums == null || nums.length < k){
			return res;
		}
		
		int N = nums.length;
		int median = findMedian(nums);
		
		Comparator<Integer> closeToMedian = new CloseToMedian(median);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, closeToMedian);
		
		for (int i = 0; i < N; i++){
			pq.add(nums[i]);
		}
		
		for (int i = 0; i < k; i++){
			res.add(pq.poll());
		}
		
		return res;
		
	}
	
	private int findMedian(int[] nums){
		int midIndex = (nums.length - 1) / 2;
		return quickSelect(nums, midIndex);
	}
	
	
	private int quickSelect(int[] nums, int k){
	
		int N = nums.length;
		int lo  = 0, hi = N - 1;
		
		while (lo < hi){
		
			int j = partition(nums, lo, hi);
			
			if (j == k){
				return nums[k];
			}
			
			else if (j < k){
				lo = j + 1;
			}
			
			else{
				hi = j - 1;
			}
		}
		
		return nums[k];
	
	}
	
	private int partition(int[] nums, int lo, int hi){
		
		int i = lo;
		int j = hi + 1;
		
		int pv = nums[lo];
		
		while (true){
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
	
	private void exch(int[] num, int i, int j){
		
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
		
	}
	
	public static void main(String[] argv){
		
		int[] nums = {1, 2, 3, 5, 7, 8, 9, 10, 12, 13, 15};
		
		KthClosestToMedian test = new KthClosestToMedian();
		System.out.println(test.getKthClosestToMedian(nums, 3).toString());
		
	}

}
