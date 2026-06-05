class Solution {
    int m;
    int n;
    int[][] dirs = new int[][] {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };
    public void printBoard(char[][] board) {
        System.out.println("BOARD");
        for (int i = 0 ; i < m; i++)
            System.out.println(Arrays.toString(board[i]));
    }
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        
        for (int i = 0 ; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
        }
        printBoard(board);
        for (int j = 0 ; j < n; j++){
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[m - 1][j] == 'O') dfs(board, m - 1, j);
        }

        for (int i = 0 ; i < m; i++)
        for (int j = 0 ; j < n; j++)
            if (board[i][j] == 'O') board[i][j] = 'X';

        for (int i = 0 ; i < m; i++)
        for (int j = 0 ; j < n; j++)
            if (board[i][j] == 'C') board[i][j] = 'O';
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i == m || j == n) return;
        if (board[i][j] == 'X' || board[i][j] == 'C') return;
        board[i][j] = 'C';
        for (int[] d: dirs) {
            int x = i + d[0];
            int y = j + d[1];
            dfs(board, x, y);
        }
    }
}
