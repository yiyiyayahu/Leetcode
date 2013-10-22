public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        
        if(m < 1 || n < 1) return 0;
        if(obstacleGrid[m-1][n-1] == 1) return 0;

        path[m-1][n-1] = 1;
        for(int i = m-1; i >= 0; i--) {
            if(obstacleGrid[i][n-1] == 0) {
                path[i][n-1] = 1;
            } else {
                path[i][n-1] = 0;
                break;
            }
        }
        for(int j = n-1; j >= 0; j--) {
            if(obstacleGrid[m-1][j] == 0) {
                path[m-1][j] = 1;
            } else {
                path[m-1][j] = 0;
                break;
            }
        }
        if(m > 1 && n > 1) {
            for(int i = m-2; i >= 0; i--) {
                for(int j = n-2; j >= 0; j--) {
                    if(obstacleGrid[i][j] == 0) {
                        path[i][j] = path[i+1][j] + path[i][j+1];
                    } else {
                        path[i][j] = 0;
                    }
                }
            }
        }
        return path[0][0];
    }
}

//better solution using dp
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 0) {
                    if(i == 0 && j == 0) {
                        path[i][j] = 1;
                    } else {
                        path[i][j] = (i>0?path[i-1][j]:0) + (j>0?path[i][j-1]:0); //Be careful
                    }
                }
            }
        }
        return path[m-1][n-1];  
    }

}
