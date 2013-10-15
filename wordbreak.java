public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        if(s == null || dict == null) return false;
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        for(String str : dict) {
            map.put(str, true);
        }
        return wordBreakHelper(s, dict, map);
    }
    public boolean wordBreakHelper(String s, Set<String> dict, HashMap<String, Boolean> map) {
        if(map.containsKey(s)) return map.get(s);
        
        for(int i = 1; i < s.length(); i ++) {
            String left = s.substring(0,i);
            String right = s.substring(i);
            if(map.containsKey(left) && map.get(left) == true && wordBreakHelper(right, dict, map)) {
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
