package inter_tree;

public class DeepestLeftNodeInBST {
	
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	public class Result{
		
		TreeNode node;
		int depth;
		
		public Result(TreeNode node, int depth){
			this.node = node;
			this.depth = depth;
		}
		
	}
	
	public TreeNode findDeepestLeft(TreeNode root){
		
		if (root == null){
			return null;
		}
		
		Result res = new Result(root, 0);
		findHelper(root, 0, res, true);
		
		return res.node;
		
	}
	
	private void findHelper(TreeNode node, int depth, Result res, boolean isLeft){
		
		if (node == null){
			return;
		}
		
		if (isLeft && res.depth < depth && node.left == null && node.right == null){
			res.node = node;
			res.depth = depth;
		}
		
		findHelper(node.left, depth + 1, res, true);
		findHelper(node.right, depth + 1, res, false);
		
	}

}
