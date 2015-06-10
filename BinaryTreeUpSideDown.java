package tree;

import java.util.Stack;

public class BinaryTreeUpSideDown {
	
	
	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

	public TreeNode upSideDown(TreeNode root){
	
		if (root == null){
			return root;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode cur = root;
		
		while (cur != null){
			stack.push(cur);
			cur = cur.left;
		}
		
		TreeNode newRoot = stack.pop();
		TreeNode preNode = newRoot;
		
		while (!stack.isEmpty()){
			TreeNode curNode = stack.pop();
			preNode.left = curNode.right;
			preNode.right = curNode;
			curNode.left = null;
			curNode.right = null;
			
			preNode = curNode;
		}
		
		return newRoot;
	
	}
	
	public static void main(String[] argv){
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(6);
		
		BinaryTreeUpSideDown test = new BinaryTreeUpSideDown();
		TreeNode newRoot = test.upSideDown(root);
		System.out.println(newRoot.val);
		System.out.println(newRoot.left.val);
		System.out.println(newRoot.right.val);
		
	}

}
