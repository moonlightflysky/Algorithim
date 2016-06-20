package inter_tree;

import java.util.*;

public class PrintBinaryTreeBoundary {
	
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	public ArrayList<Integer> printBoundary(TreeNode root){
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		if (root == null){
			return res;
		}
		
		res.add(root.val);
		
		printLeftSide(root.left, res);
		printLeaves(root.left, res);
		printLeaves(root.right, res);
		
		printRightSide(root.right, res);
		
		return res;
		
	}
	
	private void printLeftSide(TreeNode node, ArrayList<Integer> res){
		
		if (node == null){
			return;
		}
		
		if (node.left != null){
			res.add(node.val);
			printLeftSide(node.left, res);
		}
		
		else if (node.right != null){
			res.add(node.val);
			printLeftSide(node.right, res);
		}
		
	}
	
	private void printLeaves(TreeNode node, ArrayList<Integer> res){
		if (node == null){
			return;
		}
		
		if (node.left == null && node.right == null){
			res.add(node.val);
			return;
		}
		
		printLeaves(node.left, res);
		printLeaves(node.right, res);
	}
	
	private void printRightSide(TreeNode node, ArrayList<Integer> res){
		
		if (node == null){
			return;
		}
		
		if (node.right != null){
			printRightSide(node.right, res);
			res.add(node.val);
		}
		
		else if (node.left != null){
			printRightSide(node.left, res);
			res.add(node.val);
		}
		
	}
	
	public static void main(String[] argv){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(11);
		root.right.left.left = new TreeNode(12);
		root.right.left.right = new TreeNode(13);
		root.right.right.left = new TreeNode(14);
		root.right.right.right = new TreeNode(15);
		root.left.left.left.left = new TreeNode(16);
		root.left.left.left.right = new TreeNode(17);
		root.right.right.right.left = new TreeNode(18);
		
		
		PrintBinaryTreeBoundary test = new PrintBinaryTreeBoundary();
		System.out.println(test.printBoundary(root).toString());
		
		
		
		
		
	}
	
	

}
