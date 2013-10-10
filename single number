/*
Given an array of integers, every element appears twice except for one. Find that single one.
*/
public class Solution {
    public int singleNumber(int[] A) {
        if(A == null) {
            throw new NullPointerException();
        }
        int result = 0;
        for(int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }
}
