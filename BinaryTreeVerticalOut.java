package common;

import java.util.ArrayList;

public class BinaryTreeVerticalOut{
	
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	public ArrayList<ArrayList<Integer>> verticalOut(TreeNode root){
	
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		if (root == null){
			return res;
		}
		
		int[] index = new int[1];
		
		verticalHelper(root, index, false, res);
		
		return res;
	
	}
	
	
	private void verticalHelper(TreeNode node, int[] index, boolean start, ArrayList<ArrayList<Integer>> res){
	
		if (node.left != null){
			
			if (start){
				index[0]--;
			}
			
			verticalHelper(node.left, index, start, res);
			index[0]++;
		
		}
		
		if (!start){
			start = true;
		}
		
		if (res.size() == index[0]){
			ArrayList<Integer> item = new ArrayList<Integer>();
			res.add(item);
		}
		
		res.get(index[0]).add(node.val);
		
		if (node.right != null){
			index[0]++;
			verticalHelper(node.right, index, start, res);
			index[0]--;
		}
	
	}
	
	public static void main(String[] argv){
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(6);
		
		BinaryTreeVerticalOut test = new BinaryTreeVerticalOut();
		
		ArrayList<ArrayList<Integer>> res = test.verticalOut(root);
		
		System.out.println(res.toString());
		
	}

}
