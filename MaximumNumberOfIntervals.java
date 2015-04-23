package intervals;

import java.util.Comparator;
import java.util.Arrays;

public class MaximumNumbersOfIntervals{

	public static class Interval{
		int start;
		int end;
	
		public Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	
	public class ByEnd implements Comparator<Interval>{
		
		public int compare(Interval a, Interval b){
		
			if (a.end < b.end){
				return -1;
			}
			
			else if (a.end > b.end){
				return 1;
			}
			
			else{
				if (a.start < b.start){
					return -1;
				}
				
				else if (a.start > b.start){
					return 1;
				}
				
				else{
					return 0;
				}
			}
		}
	}

	public int maxNumOfIntervals(Interval[] intervals){
		
		if (intervals == null || intervals.length == 0){
			return 0;
		}
		
		int N = intervals.length;
		int globalMax = 1;
		int[] dp = new int[N + 1];
		
		Comparator<Interval> byEnd = new ByEnd();
		Arrays.sort(intervals, byEnd);
		
		for (int i = 1; i < N; i++){
			Interval curInterval = intervals[i];
			int preIndex = findIndex(intervals, curInterval.start);
			dp[i] = Math.max(dp[preIndex + 1] + 1, dp[i - 1]);
			globalMax = Math.max(globalMax, dp[i]);
		}
		
		return globalMax;
		
	}
	
	private int findIndex(Interval[] intervals, int end){
	
		int N = intervals.length;
		int lo = 0, hi = N - 1;
		
		while (lo <= hi){
			
			int mid = lo + (hi - lo) /2;
			int endValue = intervals[mid].end;
			
			if (endValue == end){
				return mid;
			}
			
			else if (endValue < end){
				lo = mid + 1;
			}
			
			else{
				hi = mid - 1;
			}
		}
		
		return hi;
	
	}
	
	public static void main(String[] argv){
		
		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(3, 8);
		Interval i3 = new Interval(4, 5);
		Interval i4 = new Interval(7, 9);
		Interval i5 = new Interval(3, 6);
		Interval i6 = new Interval(5, 8);
		Interval i7 = new Interval(8, 9);
		
		Interval[] intervals = {i1, i2, i3, i4, i5, i6, i7};
		
		MaximumNumbersOfIntervals test = new MaximumNumbersOfIntervals();
		int res = test.maxNumOfIntervals(intervals);
		System.out.println(res);
		
	}

}
