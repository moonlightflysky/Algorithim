package common;


public class ConstructDListFromBST {

	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	public TreeNode BSTtoList(TreeNode root){
	
		if (root == null){
			return null;
		}
		
		TreeNode[] pre = new TreeNode[1];
		TreeNode[] head = new TreeNode[1];
		
		convertHelper(root, pre, head);
		
		return head[0];
	}
	
	
	private void convertHelper(TreeNode node, TreeNode[] pre, TreeNode[] head){
		
		if (node == null){
			return;
		}
		
		convertHelper(node.left, pre, head);
		
		if (head[0] == null){
			head[0] = node;
		}
		
		if (pre[0] != null){
			node.left = pre[0];
			pre[0].right = node;
		}
		
		//head[0].left = node;
		
		//TreeNode right = node.right;
		pre[0] = node;
		
		convertHelper(node.right, pre, head);
	
	}
	
	public static void main(String[] argv){
		
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(4);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);
		root.left.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(3);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(18);
		root.right.right.right = new TreeNode(20);
		
		
		ConstructDListFromBST test = new ConstructDListFromBST();
		TreeNode head = test.BSTtoList(root);
		TreeNode cur = head;
		
		while (cur != null){
			
			System.out.print(cur.val + "==> ");
			cur = cur.right;
		}
		
	}

}
