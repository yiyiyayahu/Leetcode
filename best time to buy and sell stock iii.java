//only by using DP can pass the test case
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        
        int maxProfit = 0;
        int[] leftmax = new int[prices.length];
        int[] rightmax = new int[prices.length];
        
        int lowest = prices[0];
        int highest = prices[prices.length-1];

        for(int i = 0; i < prices.length; i++) {
            if(lowest > prices[i]) lowest = prices[i];
            if(i > 0) leftmax[i] = Math.max(leftmax[i-1], prices[i] - lowest);
        }
        for(int i = prices.length - 1; i >= 0; i --) {
            if(highest < prices[i]) highest = prices[i];
            if(i < prices.length-1) rightmax[i] = Math.max(rightmax[i+1], highest - prices[i]);
            maxProfit = Math.max(maxProfit, leftmax[i] + rightmax[i]);
        }
        return maxProfit;
    }
}
