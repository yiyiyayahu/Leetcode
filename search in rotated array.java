public class Solution {
    public int search(int[] A, int target) {
        if(A == null || A.length == 0) return -1;
        int index = 0;
        for(int i = 1; i < A.length; i++) {
            if(A[i] < A[i-1]) {
                index = i - 1;
            }
        }
        int searchLeft = search(A, target, 0, index);
        if(searchLeft == -1) {
            return search(A, target, index+1, A.length - 1);
        } else {
            return searchLeft;
        }
    }
    public int search(int[] A, int target, int start, int end) {
        if(start > end) return -1;
        int mid = (start + end)/2;
        if(target == A[mid]) {
            return mid;
        } else if(target < A[mid]) {
            return search(A, target, start, mid - 1);
        } else {
            return search(A, target, mid + 1, end);
        }
    }
}
