package google;

public class QuadTree {
	
	public class QuadNode{
		public int len;
		public int numOfOnes;
		
		public QuadNode[] children;
		
		public boolean allZero(){
			return numOfOnes == 0;
		}
		public boolean allOnes(){
			return numOfOnes == len * len;
		}
		
		public QuadNode(int len, int numOfOnes){
			this.len = len;
			this.numOfOnes = numOfOnes;
			children = new QuadNode[4];
		}
		
	}
	
	public QuadNode and(QuadNode node1, QuadNode node2){
		
		if (node1 == null || node2 == null){
			return null;
		}
		
		int curLen = node1.len;
		QuadNode node = new QuadNode(curLen, 0);
		
		if (node1.allZero() || node2.allZero()){
			return node;
		}
		
		else if (node1.allOnes() && node2.allOnes()){
			node.numOfOnes = node1.numOfOnes;
			return node;
		}
		
		else if (node1.allOnes()){
			node.numOfOnes = node2.numOfOnes;
			return node;
		}
		
		else if (node2.allOnes()){
			node.numOfOnes = node1.numOfOnes;
			return node;
		}
		
		else{
			for (int i = 0; i < 4; i++){
				node.children[i] = and(node1.children[i], node2.children[i]);
				node.numOfOnes += node.children[i].numOfOnes;
			}
			
			return node;
		}
		
		
	}

}
