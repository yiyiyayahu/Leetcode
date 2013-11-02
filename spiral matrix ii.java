public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n > 0) generate(matrix, 1, 0, n-1, 0, n-1);
        return matrix;
    }
    public void generate(int[][] matrix, int num, int rstart, int rend, int colstart, int colend) {
        if(rstart > rend || colstart > colend) return;
        
        for(int j = colstart; j <= colend; j++) {
            matrix[rstart][j] = num ++;
        }
        for(int i = rstart + 1; i <= rend; i++) {
            matrix[i][colend] = num ++;
        }
        for(int j = colend - 1; j >= colstart; j--) {
            if(rend > rstart) matrix[rend][j] = num++; //remember to add this condition
        }
        for(int i = rend - 1; i > rstart; i--) {
            if(colend > colstart) matrix[i][colstart] = num ++;
        }
        generate(matrix, num, rstart + 1, rend - 1, colstart + 1, colend - 1); 
    }
}
