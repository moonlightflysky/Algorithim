import java.util.ArrayList;
import java.util.Stack;

public class ExpToRPN{

	public ArrayList<String> convertToRPN(String[] exp){
	
		ArrayList<String> res = new ArrayList<String>();
		if (exp == null || exp.length == 0){
			return res;
		}
		
		int N = exp.length;
		Stack<String> stack = new Stack<String>();
		
		for (int i = 0; i < N; i++){
			
			if (isOPS(exp[i])){
				
				while (!stack.isEmpty() && valueOfOPS(stack.peek()) >= valueOfOPS(exp[i])){
					String ops = stack.pop();
					res.add(ops);
				}
				
				stack.push(exp[i]);
				
			}
			
			else if (exp[i].equals("(")){
				stack.push(exp[i]);
			}
			
			else if (exp[i].equals(")")){
				while (!stack.isEmpty()){
					String ops = stack.pop();
					
					if (ops.equals("(")){
						break;
					}
					
					res.add(ops);
				}
			}
			
			else{
				res.add(exp[i]);
			}
		
		}
		
		while (!stack.isEmpty()){
			res.add(stack.pop());
		}
		
		return res;
	}
	
	private int valueOfOPS(String ops){
		
		if (ops.equals("(")){
			return 0;
		}
		
		else if (ops.equals("+") || ops.equals("-")){
			return 1;
		}
		
		else{
			return 2;
		}
	}
	
	private boolean isOPS(String s){
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}

	public static void main(String[] agrv){
		
		String[] exp = {"3", "-", "4", "+", "5"};
		
		ExpToRPN test = new ExpToRPN();
		System.out.println(test.convertToRPN(exp).toString());
		
	}
	
}
