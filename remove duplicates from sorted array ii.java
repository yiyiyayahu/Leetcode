//a duplicate can appear at most twice
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0) return 0;
        int index = 1;
        int dup = 0;
        for(int i = 1; i < A.length; i++) {
            if(A[i] != A[i-1]) {
                dup = 0;
                A[index] = A[i];
                index ++;
            } else {
                dup ++;
                if(dup < 2) {
                    A[index] = A[i];
                    index ++;
                }
            }
        }
        return index;
    }
}
