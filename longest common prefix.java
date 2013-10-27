public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        
        String s1 = strs[0];
        int index = 0;
        while(index < s1.length()) {
            char c = s1.charAt(index);
            for(int i = 0; i < strs.length; i++) {
                if(index>=strs[i].length() || strs[i].charAt(index) != c) {
                    return s1.substring(0,index);
                }
                
            }
            index++;
        }
        return s1;
    }
}
