package tree;

import java.util.ArrayList;

public class MorrisTreeInOrderTraverSal {
	
	public static class TreeNode{
		
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val){
			this.val = val;
			left = null;
			right = null;
		}
		
	}
	
	public ArrayList<Integer> morrisInOrderTraversal(TreeNode root){
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		if (root == null){
			return res;
		}
		
		TreeNode cur = root;
		while (cur != null){
			
			TreeNode pre = null;
			
			if (cur.left != null){
				pre = cur.left;
				
				while (pre.right != null && pre.right != cur){
					pre = pre.right;
				}
				
				if (pre.right == null){
					pre.right = cur;
					cur = cur.left;
				}
				
				else{
					pre.right = null;
					res.add(cur.val);
					cur = cur.right;
				}
			}
			
			
			else{
				res.add(cur.val);
				cur = cur.right;
			}
		}
		
		return res;
	}
	
	public static void main(String[] argv){
		
		TreeNode root = new TreeNode (8);
		root.left = new TreeNode(4);
		root.right = new TreeNode(10);
		
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		left.left = new TreeNode (2);
		left.left.left = new TreeNode (1);
		left.right = new TreeNode (6);
		left.right.left = new TreeNode (5);
		
		right.left = new TreeNode (9);
		right.right = new TreeNode(12);
		
		MorrisTreeInOrderTraverSal test = new MorrisTreeInOrderTraverSal();
		ArrayList<Integer> res = test.morrisInOrderTraversal(root);
		System.out.println(res.toString());
		
	}

}
