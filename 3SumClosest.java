public class Solution {
    public int threeSumClosest(int[] num, int target) {
    
        Arrays.sort(num);
        int min = num[0] + num[1] + num[2];
        if(target == min || num.length == 3) return min;
        for(int i = 0; i < num.length -2; i++) {
            int newTarget = target - num[i];
            int start = i + 1;
            int end = num.length - 1;
            while(start < end) {
                int sum = num[start] + num[end];
                if(Math.abs(min - target) > Math.abs(sum - newTarget)) {
                    min = sum + num[i];
                }
                if(sum == newTarget) {
                    return newTarget + num[i];
                }
                if(sum < newTarget) {
                    start ++;
                } else {
                    end --;
                }
            }
        }
        return min;
    }
}
