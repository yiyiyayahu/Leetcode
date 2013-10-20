//To avoid duplicates, if I find the next element to search is the same as this round, skip it.
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length - 2; i ++) {
            if(i >=1 && num[i] == num[i-1]) continue; 
            int first = i + 1;
            int last = num.length - 1;
            while(first < last) {
                int sum = num[first] + num[last] + num[i];
                if(sum < 0) {
                    first ++;
                } else if(sum > 0) {
                    last --;
                } else {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[first]);
                    list.add(num[last]);
                    ret.add(list);

                    while(first < last && num[first] == num[first+1]) first ++;
                    while(first < last && num[last] == num[last-1]) last --;
                    first ++;
                    last --; 
                }
            }

        }
        return ret;
    }
}
