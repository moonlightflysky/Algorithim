package common;

import java.util.ArrayList;
import java.util.Stack;


public class PrintPathsFromRootToLeaf {
	
	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
	public ArrayList<ArrayList<Integer>> printPaths(TreeNode root){
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		if (root == null){
			return res;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode cur = root;
		TreeNode pre = null;
		
		while (cur != null || !stack.isEmpty()){
			
			if (cur != null){
				stack.push(cur);
				cur = cur.left;
				
			}
			else{
				TreeNode t = stack.peek();
			
				if (t.right != null && t.right != pre){
					cur = t.right;
				}
			
				else{
					
					if (t.right == null){
						ArrayList<Integer> item = new ArrayList<Integer>();
						for (TreeNode node : stack){
							item.add(0, node.val);
						}
						res.add(item);
					}
				
					pre = t;
					stack.pop();
				}
			}
		}
		
		return res;
		
	}
	
	public static void main(String[] argv){
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		PrintPathsFromRootToLeaf test = new PrintPathsFromRootToLeaf();
		System.out.println(test.printPaths(root).toString());
		
	}

}
