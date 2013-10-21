public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int max = 0;
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i < height.length; i++) {
            if(s.isEmpty() || height[i] > height[s.peek()]) {
                s.push(i);
            } else {
                int index = s.pop();
                int area = height[index] * (s.isEmpty()? i : i - s.peek() - 1);
                if(area > max) max = area;
                i --;
            }
        }
        while(!s.isEmpty()) {
            int k = s.pop();
            int width = s.isEmpty() ? height.length : height.length - s.peek() - 1;
            int area = height[k] * width;
            if(area > max) max = area;
        }
        return max;
        
    }
}
