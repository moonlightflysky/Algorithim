public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int M = Math.min(m, n);
        int N = Math.max(m, n);
        
        boolean colIsBig = m < n;
        
        int res = Integer.MIN_VALUE;
        
        for (int i = 0; i < M; i++){
            
            int[] sum = new int[N];
            
            for (int j = i; j >= 0; j--){
                
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                
                int curVal = 0;
                
                for (int k = 0; k < N; k++){
                    
                    sum[k] += colIsBig? matrix[j][k] : matrix[k][j];
                    curVal += sum[k];
                    
                    Integer subVal = set.ceiling(curVal-target);
                    if(subVal != null){
                        res=Math.max(res,curVal-subVal);
                    }
                    set.add(curVal);
                    
                    
                }
                
            }
            
        }
        
        return res;
        
        
    }
}
