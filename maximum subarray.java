//consider the situation that the array only contains negative value, so initialize the max to be Integer.MIN_VALUE

public class Solution {
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            //Put this part before sum = 0. 
            //So if the array only contains negative value, max will be the smallest negative number, instead of 0
            if(max < sum) {
                max = sum;
            }
            
            if(sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
