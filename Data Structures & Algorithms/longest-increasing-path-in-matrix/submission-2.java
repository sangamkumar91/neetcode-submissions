class Solution {
    int m;
    int n;
    int[][] directions = new int[][] {
        {1, 0},
        {0, 1},
        {0, -1},
        {-1, 0}
    };
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n];
        int result = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, i, j, memo));
            }

        return result;        
    }
    public int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];
        int result = 0;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0 || x == m || y == n) continue;
            if (matrix[x][y] > matrix[i][j]) {
                result = Math.max(result, dfs(matrix, x, y, memo));
            }
        }
        memo[i][j] = result + 1;
        return memo[i][j];
    }

}
