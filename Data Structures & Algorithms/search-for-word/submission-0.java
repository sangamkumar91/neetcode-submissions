class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wArr = word.toCharArray();
        for (int i = 0 ; i < board.length ; i++)
            for (int j = 0 ; j < board[0].length ; j++) {
               if (dfs(board, wArr, 0, i, j)) return true; 
            }
        return false;
        
    }
    public boolean dfs(char[][] board, char[] wArr, int index, int i, int j) {
        if (index == wArr.length) return true;
        if (i < 0 || i == board.length) return false;
        if (j < 0 || j == board[0].length) return false;
        if (wArr[index] != board[i][j]) return false;
        char c = board[i][j];
        board[i][j] = '*';
        boolean result = dfs(board, wArr, index + 1, i + 1, j) ||
            dfs(board, wArr, index + 1, i - 1, j) ||
            dfs(board, wArr, index + 1, i, j + 1) ||
            dfs(board, wArr, index + 1, i, j - 1);
        board[i][j] = c;
        return result;

    }

}
