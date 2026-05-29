class Solution {
    int[][] dir = new int[][] {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0 ; i < grid.length; i++)
           for (int j = 0 ; j < grid[0].length; j++)
                result = Math.max(result, bfs(grid, i, j));
        return result;
    }

    public int bfs(int[][] grid, int i, int j) {
        if (grid[i][j] != 1) return 0;
        ArrayDeque<int[]> q = new ArrayDeque();
        q.offerFirst(new int[] {i, j});
        int area = 0;
        grid[i][j] = 2;
        while(!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] cell = q.pollLast();
                area++;
                for (int[] d: dir) {
                    int x = cell[0] + d[0];
                    int y = cell[1] + d[1];
                    if (x < 0 || y < 0) continue;
                    if (x == grid.length || y == grid[0].length) continue;
                    if (grid[x][y] != 1) continue;
                    grid[x][y] = 2;
                    q.offerFirst(new int[] {x, y});
                }
                size--;
            }
        }
        return area;
    }

}
