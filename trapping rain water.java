public class Solution {
    public int trap(int[] A) {
        //min(left, right) > A[i]. trap += min(left, right) - A[i]
        if(A == null || A.length == 0) {return 0;}
        
        int volume = 0;
        int[] leftMost = new int[A.length];
        int[] rightMost = new int[A.length];
        int leftMax = A[0];
        for(int i = 0; i < A.length; i++) {
            if(A[i] > leftMax) leftMax = A[i];
            leftMost[i] = Math.max(leftMax, A[i]);
        }
        int rightMax = A[A.length - 1];
        for(int i = A.length - 1; i >= 0; i--) {
            if(A[i] > rightMax) rightMax = A[i];
            rightMost[i] = Math.max(rightMax, A[i]);
        }
        for(int i = 0; i < A.length; i++) {
            int max = Math.min(leftMost[i], rightMost[i]);
            if(max > A[i]) {
                volume += max - A[i];
            }
        }
        return volume;
    }
}
