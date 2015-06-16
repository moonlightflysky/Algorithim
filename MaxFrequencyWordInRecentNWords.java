package common;

import java.util.HashMap;

public class MaxFrequencyWordInRecentNWords{

	public class DListNode{
		
		String key;
		int freq;
		DListNode pre, next;
		
		public DListNode(String key, int freq){
			this.key = key;
			this.freq = freq;
			pre = null;
			next = null;
		}
	
	}
	
	private DListNode head = null, tail = null;
	private HashMap<String, DListNode> map = new HashMap<String, DListNode>();
	
	public String[] findMaxInWindow(String[] words, int w){
	
		if (words == null || words.length == 0){
			return null;
		}
		
		int N = words.length;
		
		if (N <= w){
			
			HashMap<String, Integer> map2 = new HashMap<String, Integer>();
			
			String res = words[0];
			int max = 0;
			
			for (int i = 0; i < N; i++){
			
				String s = words[i];
				
				if (map2.containsKey(s)){
					map2.put(s, map2.get(s) + 1);
				}
				
				else{
					map2.put(s, 1);
				}
				
				if (map2.get(s) > max){
					res = s;
					max = map2.get(s);
				}
			
			}
			
			return new String[] {res};
		}
		
		String[] res = new String[N - w + 1];
		
		for (int i = 0; i < w; i++){
			String s = words[i];
			if (map.containsKey(s)){
				map.get(s).freq++;
				swim(map.get(s));
			}
			
			else{
				DListNode node = new DListNode(s, 1);
				insertBack(node);
				map.put(s, node);
			}
			
			
		}
		
		for (int i = w; i < N; i++){
			
			res[i - w] = head.key;
			
			
			/*if (true){
				DListNode cur = head;
				System.out.print(i - w + " ");
				while (cur != null){
					System.out.print(" key: " + cur.key + " freq: " + cur.freq + " => ");
					cur = cur.next;
				}
				System.out.print("\n");
			}*/
			
			if (map.containsKey(words[i - w])){
				
				DListNode rNode = map.get(words[i - w]);
				
				if (rNode.freq == 1){
					map.remove(words[i - w]);
					removeNode(rNode);
				}
				
				else{
					rNode.freq--;
					sink(rNode);
				}
			}
			
			String s = words[i];
			
			if (map.containsKey(s)){
				DListNode curNode = map.get(s);
				curNode.freq++;
				swim(curNode);
			}
			
			else{
				DListNode curNode = new DListNode(s, 1);
				insertBack(curNode);
				map.put(s, curNode);
			}
			
		}
		
		res[N - w] = head.key;
		
		return res;
		
	}
	
	private void swim(DListNode node){
		
		while (node.pre != null && node.freq >= node.pre.freq){
			exch(node, node.pre);
			node = node.pre;
		}
	}
	
	private void exch(DListNode node1, DListNode node2){
		String tempKey = node1.key;
		int tempFreq = node1.freq;
		node1.key = node2.key;
		node1.freq = node2.freq;
		node2.key = tempKey;
		node2.freq = tempFreq;
		
		map.put(node1.key, node1);
		map.put(node2.key, node2);
	}
	
	private void removeNode(DListNode node){
		if (head == tail){
			head = null;
			tail = null;
			return;
		}
		
		if (node == head){
			DListNode temp = head.next;
			head.next = null;
			temp.pre = null;
			head = temp;
			return;
		}
		
		if (node == tail){
			DListNode temp = node.pre;
			tail.pre = null;
			temp.next = null;
			tail = temp;
			return;
		}
		
		else{
			DListNode preNode = node.pre;
			DListNode nextNode = node.next;
			node.pre = null;
			node.next = null;
			preNode.next = nextNode;
			nextNode.pre = preNode;
		}
		
		
	}
	
	private void sink(DListNode node){
	
		while (node.next != null && node.freq < node.next.freq){
			exch(node, node.next);
			node = node.next;
		}
	
	}
	
	private void insertBack(DListNode node){
		if (head == null){
			head = node;
			tail = node;
			return;
		}
		
		else{
			DListNode temp = tail;
			node.pre = temp;
			temp.next = node;
			tail = node;
		}
	}
	
	
	public static void main(String[] argv){
		
		String[] words = {"like", "book", "cook", "baozi", "baozi","cook" , "baozi", "book", "book", "like", "book", 
							"cook", "baozi", "like", "book", "cook", "like", "like"};
		
		MaxFrequencyWordInRecentNWords test = new MaxFrequencyWordInRecentNWords();
		
		String[] res = test.findMaxInWindow(words, 6);
		
		int N = res.length;
		System.out.println(N - 1);
		for (int i = 0; i < N; i++){
			System.out.println(res[i]);
		}
		
	}
	
}
