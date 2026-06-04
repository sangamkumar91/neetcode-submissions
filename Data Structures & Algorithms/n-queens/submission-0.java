class Solution {
    HashSet<Integer>[][] board = null; 
    int n;
    char[][] view = null;
    int[][] diag = new int[][] {
        {1,1},
        {-1, -1},
        {1, -1},
        {-1, 1}
    };
    List<List<String>> result = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        this.board = new HashSet[n][n];
        this.n = n;
        for (int i = 0; i < n ; i++)
        for (int j = 0; j < n ; j++)
            board[i][j] = new HashSet<Integer>();
        view = new char[n][n];
        for (int i = 0; i < n ; i++)
        for (int j = 0; j < n ; j++)
            view[i][j] = '.';
        dfs(0);
        return result;
    }
    public void dfs(int q) {
        if (q == n) {
            List<String> combination = new ArrayList();
            for (int i = 0; i < n ; i++) {
                char[] row = view[i];
                combination.add(new String(row));
            }
            result.add(combination);
            return;
        }
        for (int i = 0; i < n ; i++) {
            if (!board[i][q].isEmpty()) continue;
            placeQueen(i, q, q);
            dfs(q + 1);
            removeQueen(i, q, q);
        }
    }

    public void placeQueen(int i, int j, int q) {
        updateRows(i, q, true);
        updateCols(j, q, true);
        updateDiagonal(i, j, q, true);
        view[i][j] = 'Q';
    }
    public void removeQueen(int i, int j, int q) {
        updateRows(i, q, false);
        updateCols(j, q, false);
        updateDiagonal(i, j, q, false);        
        view[i][j] = '.';
    }

    public void updateRows(int x, int q, boolean add) {
        for(int i = 0 ; i < n; i++) {
            if (add)
                board[x][i].add(q);
            else
                board[x][i].remove(q);
        }
    }
    public void updateCols(int y, int q, boolean add) {
        for(int i = 0 ; i < n; i++) {
            if (add)
                board[i][y].add(q);
            else
                board[i][y].remove(q);
        }
    }
    public void updateDiagonal(int x, int y, int q, boolean add) {
        for(int i = 0 ; i < n; i++) {
            for (int[] dir: diag) {
                int a = x + dir[0] * i;
                int b = y + dir[1] * i;
                if (a < 0 || b < 0 || a >= n || b >= n) continue;
                if (add)
                    board[a][b].add(q);
                else
                    board[a][b].remove(q);
            }
        }
    }
}
