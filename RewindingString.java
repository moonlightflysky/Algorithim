package inter_string;

public class RewindingString {
	
	public boolean isMultipileDuplicate(String s){
		
		if (s == null || s.length() <= 1){
			return false;
		}
		
		int pStart = 0, pEnd = 0;
		int N = s.length();
		int i = 0;
		
		while (i < N){
			
			//System.out.println(pStart);
			
			if (s.charAt(i) != s.charAt(pStart)){
				if (pStart == 0){
					pEnd = i;
					i++;
				}
				else{
					pEnd = i - 1;
					pStart = 0;
				}
				
			}
			
			else{
				if (pStart == pEnd){
					if( i != s.length() - 1){
						pStart = 0;
					}
				}
				else{
					pStart++;
				}
				i++;
			}
			
		}
		
		return pStart == pEnd && pEnd > 0;
		
	}
	
	public static void main(String[] argv){
		
		RewindingString test = new RewindingString();
		System.out.println(test.isMultipileDuplicate("abcababcab"));
		
	}

}
