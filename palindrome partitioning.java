public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(s == null) return result;
        ArrayList<String> list = new ArrayList<String>();
        partition(s, 0, list, result);
        return result;
    }
    
    public void partition(String s, int start, ArrayList<String> list, ArrayList<ArrayList<String>> result) {
        if(start == s.length()) {
            ArrayList<String> newlist = new ArrayList<String>(list);
            result.add(newlist);
            return;
        }
        for(int i = start+1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if(isPalindrome(str)) {
                list.add(str);
                partition(s, i, list, result);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return false;
        for(int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        } 
        return true;
    }
}
