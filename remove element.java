public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A == null) return -1;
        int i = 0; 
        int index = 0;
        while(i < A.length) {
            if(A[i] != elem) {
                A[index] = A[i];
                index++;
            }
            i ++;
        }
        return index;
    }
}
