public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int ret = num[0] + num[1] + num[2];
        if(num.length == 3) return ret;
        for(int i = 0; i < num.length - 2; i++) {
            int first = i + 1;
            int last = num.length - 1;
            while(first < last) {
                int sum = num[i] + num[first] + num[last];
                if(Math.abs(ret - target) > Math.abs(sum - target)) {
                    ret = sum;
                }
                if(sum == target) {
                    return sum;
                } else if(sum < target) {
                    first ++;
                } else {
                    last --;
                }
            }
        }
        return ret;
    }
}
