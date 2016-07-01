public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        
        if (nestedList == null || nestedList.size() == 0){
            return 0;
        }
        
        int N = nestedList.size();
        int d = getDepth(nestedList);
        
        return sumHelper(nestedList, d);
        
    }
    
    private int getDepth(List<NestedInteger> nestedList){
        
        int depth = 1;
        
        for (NestedInteger n : nestedList){
            if (!n.isInteger()){
                depth = Math.max(depth, getDepth(n.getList()) + 1);
            }
        }
        
        return depth;
    }
    
    private int sumHelper(List<NestedInteger> nestedList, int d){
        
        if (nestedList == null){
            return 0;
        }
        
        int res = 0;
        
        System.out.println(d);
        
        for (NestedInteger n : nestedList){
            if (n.isInteger()){
                res += n.getInteger() * d;   
            }
            
            else{
                res += sumHelper(n.getList(), d - 1);
            }
        }
        
        return res;
        
    }
    
    
}
