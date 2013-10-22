public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(search(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean search(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        int x = board.length - 1;
        int y = board[0].length - 1;
        
        if(board[i][j] != word.charAt(index)) return false;
        if(index == word.length() - 1) return true;
        visited[i][j] = true; //cannot put it in front of if(board[i][j] != c) 
        
        if(i > 0 && !visited[i-1][j] && search(board, i-1, j, word, index+1, visited)) return true;
        if(i < x && !visited[i+1][j] && search(board, i+1, j, word, index+1, visited)) return true;
        if(j > 0 && !visited[i][j-1] && search(board, i, j-1, word, index+1, visited)) return true;
        if(j < y && !visited[i][j+1] && search(board, i, j+1, word, index+1, visited)) return true;
        
        visited[i][j] = false;
        return false;
    }
}
