package common;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

//http://jane4532.blogspot.com/2015/07/lintcode-sliding-window-median.html?m=0

public class SlidingWindowMedian{

	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		if (nums == null || nums.length == 0){
			return res;
		}
		
		int N = nums.length;
		
		PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>(k);
		
		for (int i = 0; i < N; i++){
			
			if (maxPQ.size() == minPQ.size()){
				
				if (!minPQ.isEmpty() && nums[i] > minPQ.peek()){
					
					maxPQ.add(minPQ.poll());
					minPQ.add(nums[i]);
				
				}
				
				else{
					
					maxPQ.add(nums[i]);
				
				}
			
			}
			
			else{
				
				if (nums[i] > maxPQ.peek()){
					
					minPQ.add(nums[i]);
				
				}
				
				
				else{
					
					minPQ.add(maxPQ.poll());
					maxPQ.add(nums[i]);
					
				}
			
			}
			
			if (i >= k - 1){
				
				res.add(maxPQ.peek());
				
				int remove = nums[i - k + 1];
				
				if (remove <= maxPQ.peek()){
					maxPQ.remove(remove);
				}
				
				else{
					minPQ.remove(remove);
				}
				
				if (minPQ.size() > maxPQ.size()){
					maxPQ.add(minPQ.poll());
				}
				
				else if (maxPQ.size() > minPQ.size() + 1){
					minPQ.add(maxPQ.poll());
				}
			
			}
		
		}
		
		return res;
	
    }
	
	public static void main(String[] argv){
		
		int[] nums= {1,2, 7, 7, 2};
		int k = 1;
		
		SlidingWindowMedian test = new SlidingWindowMedian();
		
		System.out.println(test.medianSlidingWindow(nums, k).toString());
		
	}

}
