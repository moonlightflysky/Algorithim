package inter_dfs;

import java.util.*;

public class PrettyPrintJson {
	
	public ArrayList<String> prettyPrint(String s){
		
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0){
			return res;
		}
		
		int[] pos = new int[1];
		printHelper(s, pos, -1, res);
		res.remove(0);
		return res;
	}
	
	private void printHelper(String s, int[] pos, int d, ArrayList<String> res){
		
		//System.out.println(pos[0]);
		StringBuilder sb = new StringBuilder();
		
		while(pos[0] < s.length()){
			if (s.charAt(pos[0]) == '{'){
				String item = padSpace(sb, d);
				res.add(item);
				sb.setLength(0);
				pos[0]++;
				printHelper(s, pos, d + 1, res);
			}
			
			else if (s.charAt(pos[0]) == '}'){
				String item = padSpace(sb, d);
				res.add(item);
				sb.setLength(0);
				pos[0]++;
				return;
			}
			
			else{
				sb.append(s.charAt(pos[0]++));
			}
		}
		
	}
	
	private String padSpace(StringBuilder sb, int d){
		for (int i = 0; i < d; i++){
			sb.insert(0, " ");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] argv){
		
		PrettyPrintJson test = new PrettyPrintJson();
		String s = "{a{b{cd}e}f}";
		ArrayList<String> res = test.prettyPrint(s);
		//System.out.println(res.size());
		for (int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
	}

}
