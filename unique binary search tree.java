public class Solution {
    public int numTrees(int n) { 
        int[] count = new int[n+1];
        for(int i = 0; i <= n; i++) {
            count[i] = 0;
        }
        count[0] = 1;
        count[1] = 1;
        return numTreesHelper(n, count);
    }
    
    public int numTreesHelper(int n, int[] count) {
        
        if(count[n] != 0) {
            return count[n];
        } else {
            for(int i = 1; i <= n; i ++) {
                //select i as the root
                count[n] += numTreesHelper(i-1, count) * numTreesHelper(n-i, count);
            }
        }
        return count[n];
    }
    
}
