class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int j = 0 ; j < 9 ; j++) {
            if (!checkRowAndCol(board, j)) return false;
            for (int i = 0 ; i < 9 ; i++) {
                if (i % 3 != 0) continue;
                if (j % 3 != 0) continue;
                if (!checkSubBox(board, i, j)) return false;
            }
        }

        return true;

    }

    boolean checkRowAndCol(char[][] board, int i) {
        HashSet<Character> setRow = new HashSet();
        HashSet<Character> setCol = new HashSet();
        for (int j = 0 ; j < 9 ; j++) {
            if (setRow.contains(board[i][j])) return false;
            if (board[i][j] != '.') setRow.add(board[i][j]);
            if (setCol.contains(board[j][i])) return false;
            if (board[j][i] != '.') setCol.add(board[j][i]);
        }
        return true;
    }
    boolean checkSubBox(char[][] board, int x, int y) {
        HashSet<Character> set = new HashSet();
        for (int j = 0 ; j < 3 ; j++)
            for (int i = 0 ; i < 3 ; i++) {
                if (set.contains(board[x + i][y + j])) return false;
                if (board[x + i][y + j] != '.') set.add(board[x + i][y + j]);
            }
        
        return true;
    }

}
