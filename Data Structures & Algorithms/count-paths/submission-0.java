class Solution {
    int M;
    int N;
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        M = m;
        N = n;
        return dfs(0, 0, memo);
    }

    public int dfs(int i ,int j, int[][] memo) {
        if (i == M || j == N) {
            return 0;
        }

        if (i == M - 1 && j == N - 1)
            return 1;
        if (memo[i][j] != 0) return memo[i][j];
        int down = dfs(i + 1, j, memo);
        int right = dfs(i, j + 1, memo);
        memo[i][j] = down + right; 
        return memo[i][j];
    }
}
