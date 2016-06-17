package inter_hash;

import java.util.*;

public class TaskScheduler_2nd {
	
	public int totalTime(int[] task, int cd){
		
		if (task == null || task.length == 0){
			return 0;
		}
		
		int N = task.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		
		for (int i = 0; i < N; i++){
			
			
			
			if (!map.containsKey(task[i])){
				map.put(task[i], count + cd + 1);
				count++;
			}
			
			else{
				int time = map.get(task[i]);
				if (count < time){
					count = time;
					map.put(task[i], count + cd + 1);
				}
				
				else{
					map.put(task[i], count + cd + 1);
					count++;
				}
				
			}
			
			System.out.println(count);
			
		}
		
		return count;
		
	}
	
	public static void main(String[] argv){
		
		int[] task = {1, 1, 2, 1, 2, 3, 4};
		int cd = 2;
		
		TaskScheduler_2nd test = new TaskScheduler_2nd();
		int res = test.totalTime(task, cd);
		System.out.println(res);
		
	}

}
