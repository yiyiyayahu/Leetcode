public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        if(S == null) return subsets;
        Arrays.sort(S);
        int num = 1 << S.length;
        
        for(int i = 0; i < num; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int index = 0;
            //cannot change i directly, use k
            for(int k = i; k > 0; k >>= 1) {
                if((k&1) == 1) list.add(S[index]);
                index++;
            }
            subsets.add(list);
        }
        return subsets;
    }
}
