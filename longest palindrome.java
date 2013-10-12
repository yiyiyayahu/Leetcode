public class Solution {
    public String longestPalindrome(String s) {
        if(s == null) return null;
        String result = "";
        for(int i = 0; i < s.length(); i ++) {
            String ps1 = getPalindrome(s, i, i);
            if(ps1.length() > result.length()) {
                result = ps1;
            }
            String ps2 = getPalindrome(s, i, i+1);
            if(ps2.length() > result.length()) {
                result = ps2;
            } 
        }
        return result;
    }
    public String getPalindrome(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r) ) {
            l --;
            r ++;
        }
        return s.substring(l+1, r);
    }
}
