public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] sum = new int[row][col];
        sum[0][0] = grid[0][0]; //initialization!
        return minPathSum(grid, sum, row-1, col-1);
        
    }
    public int minPathSum(int[][] grid, int[][] sum, int r, int c) {
        if(r == 0 && c == 0) return sum[0][0];
        if(sum[r][c] != 0) return sum[r][c];
        
        int sumLeft = (r >= 1 ? minPathSum(grid, sum, r-1, c) + grid[r][c] : Integer.MAX_VALUE);
        int sumUp = (c>=1 ? minPathSum(grid, sum, r, c-1) + grid[r][c] : Integer.MAX_VALUE);
        sum[r][c] = Math.min(sumLeft, sumUp);
          
        return sum[r][c];
    }
}
