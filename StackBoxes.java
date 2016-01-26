import java.util.Arrays;
import java.util.Collections;

public class StackBoxes {
	
	public class Box implements Comparable<Box>{
		int w;
		int l;
		int h;
		
		public Box(int w, int l, int h){
			this.w = w;
			this.l = l;
			this.h = h;
		}
		
		public int compareTo(Box other){
			return this.h - other.h;
		}
		
	}
	
	public int maxHeight(Box[] boxes){
		
		if (boxes == null || boxes.length == 0){
			return 0;
		}
		
		int N = boxes.length;
		Arrays.sort(boxes, Collections.reverseOrder());
		
		int[] dp = new int[N];
		
		for (int i = 0; i < N; i++){
			dp[i] = boxes[i].h;
		}
		
		int maxHeight = dp[0];
		
		for (int i = 1; i < N; i++){
			for (int j = i - 1; j >= 0; j--){
				if (boxes[i].w < boxes[j].w && boxes[i].l < boxes[j].w && boxes[i].h < boxes[j].h){
					dp[i] = Math.max(dp[i], dp[j] + boxes[i].h);
				}
			}
			
			maxHeight = Math.max(dp[i], maxHeight);
			
		}
		
		return maxHeight;
		
		
	}
	
}
