import java.util.ArrayList;
import java.util.Arrays;

public class CountOfSmallerNumber{

	public static class SegmentTreeNode {
	     int start, end, count;
	     SegmentTreeNode left;
	     SegmentTreeNode right;
	     public SegmentTreeNode(int start, int end, int count){
			this.start = start;
			this.end = end;
			this.count = count;
			this.left = null;
			this.right = null;
		 }
	}

	public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		if (A == null || A.length == 0 || queries == null || queries.length == 0){
			return res;
		}
		
		Arrays.sort(A);
		SegmentTreeNode root = buildTree(A);
		
		for (int i : queries){
			
			res.add(query(root, A, i));
		}
		
		return res;
		
	}
	
	private SegmentTreeNode buildTree(int[] A){
		int N = A.length;
		
		return buildHelper(A, 0, N - 1);
	}
	
	private SegmentTreeNode buildHelper(int[] A, int lo, int hi){
	
		if (lo > hi){
			return null;
		}
		
		if (lo == hi){
			return new SegmentTreeNode(lo, lo, 1);
		}
		
		int mid = lo + (hi - lo)/2;
		SegmentTreeNode node = new SegmentTreeNode(lo, hi, 0);
		
		node.left = buildHelper(A, lo, mid);
		node.right = buildHelper(A, mid + 1, hi);
		
		node.count = node.left.count + node.right.count;
		return node;
	}
	
	
	private int query(SegmentTreeNode root, int[] A, int q){
		if (root == null){
			return 0;
		}
   	
		int rstart = root.start;
		int rend = root.end;
   	
   	
		if (A[rstart] >= q){
			return 0;
		}
		
		if (A[rend] < q){
			return root.count;
		}
   	
   	
		int left = query(root.left, A, q);
		int right = query(root.right, A, q);
   	
		return left + right;

	}
	
	
	public static void main(String[] argv){
		
		int[] A = {1, 2, 7, 8, 5};
		int[] queries = {1, 8, 5};
		
		CountOfSmallerNumber test = new CountOfSmallerNumber();
		
		System.out.println(test.countOfSmallerNumber(A, queries).toString());
		
	}
