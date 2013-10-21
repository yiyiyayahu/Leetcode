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


public class Solution {
    public void sortColors(int[] A) {
        int index0 = 0;
        int index2 = A.length - 1;
        int i = 0;
        while(i <= index2) {
            if(A[i] == 0 && i > index0) { //remember to put the condition i > index0
                swap(A, i, index0);
                index0 ++;
                continue;
            }
            if(A[i] == 2) {
                swap(A, i, index2);
                index2 --;
                continue;
            }
            i++;  //only increment i if A[i] == 1
        }
    }
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    } 
}
