public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j ++) {
                path[i][j] = -1;
            }
        }
        path[0][0] = 1;
        return uniquePaths(m, n, path);
    }
    public int uniquePaths(int m, int n, int[][] path) {
        if(m < 1 || n < 1) return 0;
        if(path[m-1][n-1] != -1) return path[m-1][n-1]; 
        else {
            path[m-1][n-1] = uniquePaths(m, n-1, path) + uniquePaths(m-1, n, path);
            return path[m-1][n-1];
        }
    }
}
