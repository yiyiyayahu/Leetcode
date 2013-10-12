public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int num = 1;
        while(x / num >= 10) {
            num *= 10;
        }
        while(x != 0) {
            if(x/num != x%10) {
                return false;
            }
            x = (x%num)/10;    //important! considering 1000110001
            num /= 100;
        }
        return true;
    }
}
