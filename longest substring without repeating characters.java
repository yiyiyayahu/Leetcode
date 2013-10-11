public class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] array = new boolean[256];
        for(int k = 0; k < 256; k++) {
            array[k] = false;
        }
        int i = 0;
        int j = 0;
        int n = s.length();
        int maxLen = 0;
        while(j < n) {
            if(array[s.charAt(j)]) {
                maxLen = Math.max(maxLen, j - i);
                while(s.charAt(i) != s.charAt(j)) {
                    array[s.charAt(i)] = false;
                    i++;
                }
                i++;
                j++;
            } else {
                array[s.charAt(j)] = true;
                j++;
            }
        }
        maxLen = Math.max(maxLen, n - i);
        return maxLen;
    }
}
