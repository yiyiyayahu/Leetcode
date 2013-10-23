public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last  = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int top = matrix[first][i];
                matrix[first][i] = matrix[first+last-i][first];
                matrix[first+last-i][first] = matrix[last][first+last-i];
                matrix[last][first+last-i] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }
}
