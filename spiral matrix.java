public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        spiralOrder(matrix, 0, matrix.length-1, 0, matrix[0].length-1, list);
        return list;
    }
    
    public void spiralOrder(int[][]matrix, int rstart, int rend, int colstart, int colend, ArrayList<Integer> list) {
        if(rstart > rend || colstart > colend) return;
        
        for(int j = colstart; j <= colend; j++) {
            list.add(matrix[rstart][j]);
        }
        for(int i = rstart + 1; i <= rend; i++) {
            list.add(matrix[i][colend]);
        }
        for(int j = colend - 1; j >= colstart; j--) {
            if(rend > rstart) list.add(matrix[rend][j]); //remember to add this condition
        }
        for(int i = rend - 1; i > rstart; i--) {
            if(colend > colstart) list.add(matrix[i][colstart]);
        }
        spiralOrder(matrix, rstart + 1, rend - 1, colstart + 1, colend - 1, list); 
    }
}
