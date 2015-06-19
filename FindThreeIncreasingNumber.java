package interview;

public class FindThreeIncreasingNumbers{

	public int[] findThreeIncreasing(int[] nums){
		
		if (nums == null || nums.length < 3){
			return null;
		}
		
		int[] res = new int[3];
		int N = nums.length;
		int[] leftMin = getLeftMin(nums);
		
		int rightMax = nums[N - 1];
		
		for (int j = N - 2; j >= 1; j--){
			
			if (nums[j] > leftMin[j - 1] && nums[j] < rightMax){
				res[0] = leftMin[j - 1];
				res[1] = nums[j];
				res[2] = rightMax;
				
				return res;
			}
			
			else{
				rightMax = Math.max(rightMax, nums[j]);
			
			}
			
			
		}
		
		return res;
	
	}
	
	
	private int[] getLeftMin(int[] nums){
	
		int N = nums.length;
		
		int[] leftMin = new int[N];
		leftMin[0] = nums[0];
		
		for (int i = 1; i < N; i++){
			leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
		}
		
		return leftMin;
	}
	
	public static void main(String[] argv){
		
		int[] nums = {4, 3, 2 ,2, 3, 1, 5, 2, 4};
		
		FindThreeIncreasingNumbers test = new FindThreeIncreasingNumbers();
		
		int[] res = test.findThreeIncreasing(nums);
		
		System.out.println(res[0]);
		System.out.println(res[1]);
		System.out.println(res[2]);
		
	}

}
