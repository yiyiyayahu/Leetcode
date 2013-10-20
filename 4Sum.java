public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length - 3; i ++) {
            if(i >= 1 && num[i] == num[i-1]) continue;
            for(int j = i+1; j < num.length - 2; j ++) {
                
                int start = j + 1;
                int end = num.length - 1;
                while(start < end) {
                    int sum = num[i] + num[j] + num[start] + num[end];
                    if(sum < target) {
                        start ++;
                    } else if(sum > target) {
                        end --;
                    } else {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[start]);
                        list.add(num[end]);
                        ret.add(list);
                        while(start < end && num[start+1] == num[start]) start ++;
                        while(start < end && num[end] == num[end-1]) end --;
                        while(j < num.length - 2 && num[j] == num[j+1]) j++;
                        start ++;
                        end --;
                    }
                }
                
            }
        }
        return ret;
    }
}
