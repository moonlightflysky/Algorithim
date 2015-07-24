package common;

import java.util.ArrayList;

public class BinaryTreeTransform{
	
	public static class TreeNode{
		
		int val;
		ArrayList<TreeNode> children;
		
		public TreeNode(int val){
			this.val = val;
			children = new ArrayList<TreeNode>();
		}
	
	}
	
	public String encoding(TreeNode root){
		
		if (root == null){
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		
		
		sb.append(root.val);
		sb.append("(");
		for (TreeNode child : root.children){
			
			sb.append(encoding(child));
			
		}
		sb.append(")");
		
		return sb.toString();
	
	}
	
	public TreeNode decoding(String s){
		
		TreeNode sentinel = new TreeNode(-1);
		int[] pos = new int[1];
		StringBuilder sb = new StringBuilder();
		decodeHelper(s, sentinel, sb, pos);
		return sentinel.children.get(0);
	}
	
	private void decodeHelper(String s, TreeNode parent, StringBuilder sb, int[] pos){
		
		if (pos == null || pos.length == 0 || s == null || s.length() == 0){
			return;
		}
		
		
		while (pos[0] < s.length()){
			if (s.charAt(pos[0]) == '('){
				TreeNode node = new TreeNode(Integer.parseInt(sb.toString()));
				parent.children.add(node);
				
				sb.delete(0, sb.length());
				pos[0]++;
				decodeHelper(s, node,sb, pos);
			}
			
			else if (s.charAt(pos[0]) == ')'){
				pos[0]++;
				return;
				//System.out.println(pos[0]);
			}
			
			else{
				sb.append(s.charAt(pos[0]));
				pos[0]++;
			}
		}
	
	}
	
	
	public static void main(String argv[]){
		
		TreeNode root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		
		root.children.add(n1);
		root.children.add(n2);
		root.children.add(n3);
		n1.children.add(n4);
		n1.children.add(n5);
		n2.children.add(n6);
		n3.children.add(n7);
		n3.children.add(n8);
		n3.children.add(n9);
		n5.children.add(n10);
		
		BinaryTreeTransform test = new BinaryTreeTransform();
		
		String res = test.encoding(root);
		System.out.println(res.length());
		
		System.out.println(res);
		
		TreeNode resRoot = test.decoding(res);
		
		System.out.println(resRoot.val);
		for (TreeNode node: resRoot.children){
			System.out.print("; " + node.val);
		}
		System.out.println();
		
		for (TreeNode node :resRoot.children.get(0).children){
			System.out.print("; " + node.val);
		}
		
		
	}
	

}
