public class Solution {
    public int reverse(int x) {
        int result = 0;
        int last = 0;
        while(x != 0) {
            last = x % 10;
            result = result * 10 + last;
            x = x/10;
        }
        return result;
    }
}
