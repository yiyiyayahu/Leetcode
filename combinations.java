public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if(k > n || k < 0) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list =  new ArrayList<Integer>();
        combine(1, n, k, list, result);
        return result;
    }
    
    public void combine(int start, int end, int k, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {

        if(list.size() >= k) {
            ArrayList<Integer> c = new ArrayList<Integer>(list); //important
            result.add(c);
            return;
        }   
        
        for(int i = start; i <= end; i++) {
            list.add(i);
            combine(i+1, end, k, list, result);
            list.remove(list.size() -1);
        }
    }
}
