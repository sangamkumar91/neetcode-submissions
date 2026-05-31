class Solution {
    int m;
    int n;
    int[][] dir = new int[][] {
        {1, 0},
        {0, 1},
        {0, -1},
        {-1, 0}
    };
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        Queue<int[]> q = new LinkedList();
        boolean freshExists = false;
        for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++) {
            freshExists = grid[i][j] == 1 || freshExists;
            if (grid[i][j] != 2) continue;
            q.offer(new int[] {i, j});
        }
        if (!freshExists) return 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] cell = q.poll();
                for (int[] d: dir) {
                    int x = cell[0] + d[0];
                    int y = cell[1] + d[1];
                    if (x < 0 || y < 0 || x == m || y == n) continue;
                    if (grid[x][y] == 1) {
                        q.offer(new int[] {x, y});
                        grid[x][y] = 2;
                    }
                }
                size--;
            }
            result++;
        }


        for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) return -1;
        }
        return result - 1;
    }
}
