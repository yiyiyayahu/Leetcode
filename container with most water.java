public class Solution {
    public int maxArea(int[] height) {
        
        int maxValue = Math.min(height[0], height[height.length - 1]) * (height.length-1);
        int start = 0;
        int end = height.length - 1;
        while(start < end) {
            int temp = Math.min(height[start], height[end]) * (end - start);
            if(temp > maxValue) {
                maxValue = temp;
            }
            if(height[start] < height[end]) start ++; //important
            else end --;
        }
        return maxValue;
    }
}
