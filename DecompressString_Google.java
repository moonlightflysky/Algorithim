package google;

// 2[abc]3[a]c => abcabcaaac; 
//2[ab3[d]]2[cc] => abdddabdddcc

import java.util.*;

public class DecompressionString {
	
	public String decompress(String s){
		
		if (s == null || s.length() == 0){
			return "";
		}
		
		int N = s.length();
		
		//StringBuilder sb = new StringBuilder();
		Stack<Integer> numStack = new Stack<Integer>();
		Stack<Character> strStack = new Stack<Character>();
		int num = 0;
		
		for (int i = 0; i < N; i++){
			
			char c = s.charAt(i);
			
			if (Character.isDigit(c)){
				
				num = 10 * num + c - '0';
				
				if (i == N - 1 || !Character.isDigit(s.charAt(i + 1))){
					numStack.push(num);
					num = 0;
				}
				
			}
			
			else if (c == ']'){
				
				decompressHelper(numStack, strStack);
				
			}
			
			else{ // '[' and other strings
				strStack.push(c);
			}
			
			
			
		}
		
		StringBuilder res = new StringBuilder();
		while(!strStack.isEmpty()){
			res.append(strStack.pop());
		}
		
		return res.reverse().toString();
		
	}
	
	private void decompressHelper(Stack<Integer> numStack, Stack<Character> strStack){
		
		int num = numStack.pop();
		
		StringBuilder sb = new StringBuilder();
		
		while (strStack.peek() != '['){
			
			sb.append(strStack.pop());
			
		}
		
		//System.out.println(num);
		
		strStack.pop();
		
		String str = sb.toString();
		
		for (int i = 0; i < num; i++){
			
			for (int j = str.length() - 1; j >= 0; j--){
				strStack.push(str.charAt(j));
			}
			
		}
		
		
	}
	
	public static void main(String[] argv){
		
		String s1 = "2[abc]3[a]c";
		String s2 = "2[ab3[d]]2[cc]";
		
		DecompressionString test = new DecompressionString();
		System.out.println(test.decompress(s1));
		System.out.println(test.decompress(s2));
		
	}

}
