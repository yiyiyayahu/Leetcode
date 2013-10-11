// as long as it is an increasing trend, I can buy at i-1 and sell at i
//[5,1,2,3,4] 4-1=3 or (2-1)+(3-2)+(4-3)=3

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices == null) return 0;
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
}
