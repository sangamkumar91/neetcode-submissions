class Solution {
    int m;
    int n;
    int[][] dir = new int[][] {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    } ;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        int[][][] memo = new int[m][n][3];
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> result = new ArrayList();
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }
        for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++) {
            if (pacific[i][j] && atlantic[i][j])
                result.add(new ArrayList(Arrays.asList(i, j)));
        }
        return result;
    }
    public void dfs(int[][] heights, boolean[][] memo, int i, int j) {
        if (memo[i][j]) return;
        memo[i][j] = true;
        for (int[] d: dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x == m || y == n) continue;
            if (heights[x][y] < heights[i][j]) continue;
            dfs(heights, memo, x, y);
        }
    }
}
