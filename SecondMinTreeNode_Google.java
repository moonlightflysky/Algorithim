package google;

/*
 * Assumming the tree is like the parentNode 's val is always the 
 * smallest val in its children(no childrens are same)
 * 
 * like this:
 * 			2 
 * 		2			3
 * 	2		7 	3		5
 * 		
 * 
 * 
 */

import java.util.*;

public class SecondMinTreeNodeInTree {
	
	public class TreeNode{
		
		int val;
		ArrayList<TreeNode> children;
		
		public TreeNode(int val){
			this.val = val;
			children = new ArrayList<TreeNode>();
		}
		
	}
	
	public int findSecondMin(TreeNode root){
		
		if (root == null){
			return Integer.MAX_VALUE;
		}
		
		int min1 = root.val;
		int min2 = Integer.MAX_VALUE;
		TreeNode minNode = null;
		
		for (TreeNode child : root.children){
			if (child.val == min1){
				minNode = child;
			}
			else{
				if (child.val < min2){
					min2 = child.val;
				}
			}
		}
		
		
		return Math.min(findSecondMin(minNode), min2);
	}

}
