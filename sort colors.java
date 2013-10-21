public class Solution {
    public void sortColors(int[] A) {
        
        int index0 = 0;
        int index2 = A.length - 1;
        int[] array = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            array[i] = A[i];
        }
        for(int i = 0; i < A.length; i++) {
            if(array[i] == 0) {
                A[index0 ++] = 0; 
            } else if(array[i] == 2) {
                A[index2 --] = 2;
            } 
        }
        for(int j = index0 ; j <= index2; j++) {
            A[j] = 1;
        }
    }
}
