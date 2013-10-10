public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        Queue<Integer> length = new LinkedList<Integer>();
        
        queue.offer(start);
        length.offer(1);
        while(!queue.isEmpty()) {
            String curr = queue.poll();
            int len = length.poll();
            if(curr.equals(end)) {
                return len;
            } 
            for(String s : getOneEdit(curr)) {
                if(dict.contains(s)) {
                    queue.offer(s);
                    length.offer(len + 1);
                    dict.remove(s);
                }
            }
        }
        return 0;
    }
    public HashSet<String> getOneEdit(String s) {
        HashSet<String> set = new HashSet<String>();
        
        for(int i = 0; i < s.length(); i++) {
            char[] array = s.toCharArray();
            char curr = s.charAt(i);
            for(char c = 'a'; c <= 'z'; c++) {
                if(c != curr) {
                    array[i] = c;
                    set.add(new String(array));
                }
            }
        }
        return set;
    }
}
