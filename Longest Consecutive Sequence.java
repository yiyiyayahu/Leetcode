public class Solution {
     public int longestConsecutive(int[] num) {
         int max = 0;
         HashSet<Integer> h = new HashSet<Integer>();
         for(int n : num) {
             h.add(n);
         }
         for(int n: num) { //for(int n: h) is wrong
             max = Math.max(max, getCount(h,n,false) + getCount(h,n+1,true));
         }
         return max;
     }
     public int getCount(HashSet<Integer> h, int value, boolean asc) {
         int count = 0;
         while(h.contains(value)) {
             count ++;
             h.remove(value);
             if(asc) {
                 value ++;
             } else {
                 value --;
             }
         }
         return count;
     }

}
