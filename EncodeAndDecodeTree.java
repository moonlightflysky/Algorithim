package inter_tree;

import inter_tree.EncodeAndDecodeTree_2nd.TreeNode;

import java.util.ArrayList;

public class EncodeAndDecodeTree_3rd {
	
	public static class TreeNode{
		
		int val;
		ArrayList<TreeNode> children;
		
		public TreeNode(int val){
			this.val = val;
			children = new ArrayList<TreeNode>();
		}
	
	}
	
	public String encode(TreeNode root){
		
		if (root == null){
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(root.val).append("(");
		
		for (TreeNode child : root.children){
			sb.append(encode(child));
		}
		
		sb.append(")");
		
		return sb.toString();
		
	}
	
	public TreeNode decode(String s){
		
		if (s == null || s.length() == 0){
			return null;
		}
		
		int N = s.length();
		int[] pos = new int[N];
		
		return decodeHelper(s, pos).get(0);
		
	}
	
	private ArrayList<TreeNode> decodeHelper(String s, int[] pos){
		
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		
		if (s == null || s.length() == 0 ||pos == null ||pos[0] >= s.length()
				|| pos[0] < 0){
			return res;
		}
		
		int N = s.length();
		StringBuilder sb = new StringBuilder();
		TreeNode node = null;
		
		while (pos[0] < N){
			
			char c = s.charAt(pos[0]);
			
			if (c == '('){
				node = new TreeNode(Integer.parseInt(sb.toString()));
				sb.setLength(0);
				res.add(node);
				pos[0]++;
				ArrayList<TreeNode> children = decodeHelper(s, pos);
				node.children = new ArrayList<TreeNode>(children);
			}
			
			else if (c == ')'){
				pos[0]++;
				return res;
			}
			
			else{
				sb.append(c);
				pos[0]++;
			}
			
		}
		
		return res;
		
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
		
		EncodeAndDecodeTree_3rd test = new EncodeAndDecodeTree_3rd();
		
		String res = test.encode(root);
		System.out.println(res.length());
		
		System.out.println(res);
		
		TreeNode resRoot = test.decode(res);
		
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
