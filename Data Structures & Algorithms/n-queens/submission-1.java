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
    boolean[] rowFill;
    boolean[] colFill;
    boolean[] posDiagFill;
    boolean[] negDiagFill;

    List<List<String>> result = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        this.board = new HashSet[n][n];
        this.rowFill = new boolean[n];
        this.colFill = new boolean[n];
        this.posDiagFill = new boolean[2 * n];
        this.negDiagFill = new boolean[2 * n];
        this.n = n;
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
            if (rowFill[i] || colFill[q] || posDiagFill[i + q] || negDiagFill[i - q + n]) continue;
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
        rowFill[x] = add;
    }
    public void updateCols(int y, int q, boolean add) {
        colFill[y] = add;
    }
    public void updateDiagonal(int x, int y, int q, boolean add) {
        posDiagFill[x + y] = add;
        negDiagFill[x - y + n] = add;
    }
}
