package common;

public class SlidingWindowMaximum {

	public class DListNode{
		
		int index;
		DListNode pre, next;
		
		public DListNode(int index){
			this.index = index;
			pre = null;
			next = null;
		}
	
	}
	
	private DListNode head, tail;
	
	public int[] maxSlidingWindow(int[] A, int w){
	
		if (A == null || A.length == 0){
			return null;
		}
		
		int N = A.length;
		
		if (w >= N){
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++){
				max = Math.max(A[i], max);
			}
			
			return new int[] {max};
		}
		
		int[] res = new int[N - w + 1];
		
		for (int i = 0; i < w; i++){
			
			while(tail != null && A[tail.index] <= A[i]){
				removeTail();
			}
			
			DListNode node = new DListNode (i);
			insertBack(node);
		}
		
		for (int i = w; i < N; i++){
			res[i - w] = A[head.index];
			
			while (tail != null && A[tail.index] <= A[i]){
				removeTail();
			}
			
			if (head != null && head.index == i - w){
				removeHead();
			}
			
			insertBack(new DListNode(i));
		
		}
		
		res[N - w] = A[head.index];
		
		return res;
	
	}
	
	private void insertBack(DListNode node){
		if (head == null){
			head = node;
			tail = node;
			return;
		}
		
		else{
			DListNode temp = tail;
			node.pre = temp;
			temp.next = node;
			tail = node;
		}
	}
	
	private void removeTail(){
		if (tail == null){
			return;
		}
		
		if (tail == head){
			head = null;
			tail = null;
			return;
		}
		
		else{
			DListNode temp = tail.pre;
			temp.next = null;
			tail.pre = null;
			tail = temp;
		}
	}
	
	private void removeHead(){
		if (head == null){
			return;
		}
		
		if (head == tail){
			head = null;
			tail = null;
		}
		
		else{
			DListNode temp = head.next;
			temp.pre = null;
			head.next = null;
			head = temp;
		}
	}
	
	public static void main(String[] argv){
		
		int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
		
		SlidingWindowMaximum test = new SlidingWindowMaximum();
		
		int[] res = test.maxSlidingWindow(A, 3);
		
		int N = res.length;
		
		for (int i = 0; i < N; i++){
			System.out.print(res[i] + " ; ");
		}
		
		
	}

}
