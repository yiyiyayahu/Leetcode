//not a very good solution, first sort, and then use two pointers, like two sum, but also use hash set to avoid duplicates
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        if(num == null || num.length < 3) return ret;
        Arrays.sort(num);
        
        for(int i = 0; i < num.length-2; i++) {
        	
            int target = 0 - num[i];
            int start = i + 1;
            int end = num.length - 1;
            
            while(start < end) {
                ArrayList<Integer> list = new ArrayList<Integer>();
            	int sum = 0;
                sum = num[start] + num[end];
                if(sum > target) {
                    end --;
                } else if(sum < target) {
                    start ++;
                } else {
                	list.add(num[i]);
                	list.add(num[start]);
                	list.add(num[end]);
                    set.add(list);
                    start ++;
                }
            }

        }
        for(ArrayList<Integer> l : set) {
            ret.add(l);
        }
        return ret;
    }
    
}
