package common;

import java.util.HashSet;

public class TreeCycle{

	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}

	public boolean hasCycle(TreeNode root){
		
		if (root == null){
			return false;
		}
		
		HashSet<TreeNode> set = new HashSet<TreeNode>();
		set.add(root);
		return cycleHelper(root, set);
	}
	
	
	private boolean cycleHelper(TreeNode node, HashSet<TreeNode> set){
		
		if (node.left != null){
			if (set.contains(node.left)){
				return true;
			}
			
			else{
				set.add(node.left);
				if (cycleHelper(node.left, set)){
					return true;
				}
				set.remove(node.left);
			}
		}
		
		if (node.right != null){
			if (set.contains(node.right)){
				return true;
			}
			
			else{
				set.add(node.right);
				if (cycleHelper(node.right, set)){
					return true;
				}
				set.remove(node.right);
			}
		}
		
		return false;
	
	}
	
	public static void main(String[] argv){
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		
		root.left.right = root;
		
		root.left.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(6);
		
		TreeCycle test = new TreeCycle();
		
		boolean res = test.hasCycle(root);
		
		System.out.println(res);
		
	}
}
