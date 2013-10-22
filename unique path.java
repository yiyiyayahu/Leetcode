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

    //like BFS, but not exactly    bottom-up
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        if(m < 1 || n < 1) return 0;

        for(int i = 0; i <= m-1; i++) {
            path[i][n-1] = 1;
        }
        for(int j = 0; j <= n-1; j++) {
            path[m-1][j] = 1;
        }
        if(m > 1 && n > 1) {
            for(int i = m-2; i >= 0; i--) {
                for(int j = n-2; j >= 0; j--) {
                    path[i][j] = path[i+1][j] + path[i][j+1];
                }
            }
        }
        return path[0][0];
    }

//better solution
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) path[i][j]=1;
                else path[i][j] = (i>0?path[i-1][j]:0) + (j>0?path[i][j-1]:0);
            }
        }
        return path[m-1][n-1];
    }
}
