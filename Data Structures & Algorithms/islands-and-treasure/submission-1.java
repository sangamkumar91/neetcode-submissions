class Solution {
    int m;
    int n;
    int[][] dirs = new int[][] {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };
    public void islandsAndTreasure(int[][] grid) {
        m = grid.length;
        n = grid[0].length; 
        for (int i = 0 ; i < m; i++) {
            for (int j = 0 ; j < n; j++) {
                if (grid[i][j] == 0) {
                    boolean[][] visited = new boolean[m][n]; 
                    bfs(grid, visited, i, j);
                }
            }        
        }
    }
    public void bfs(int[][] grid, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[] {i , j});
        visited[i][j] = true;
        int distance = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] cell = queue.poll();
                int k = cell[0];
                int l = cell[1];
                grid[k][l] = Math.min(grid[k][l], distance);
                for (int[] d: dirs) {
                    int x = k + d[0];
                    int y = l + d[1];
                    if (x < 0 || y < 0 || x == m || y == n) continue;
                    if (grid[x][y] < distance + 1) continue;
                    queue.offer(new int[] {x, y});
                }
                size--;
            }
            distance++;
        }
    }
}
