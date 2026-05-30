class Solution {
    public int swimInWater(int[][] grid) {
        // return dfs(grid, 0, 0, null, Integer.MIN_VALUE);
        return bfs(grid);
        
    }

    public int dfs(int[][] grid, int i, int j, int[][] memo, int max) {
        if (i == grid.length - 1 && j == grid.length - 1)
            return Math.max(max, grid[i][j]);; 
        if (i < 0 || j < 0 || i == grid.length || j == grid.length)
            return Integer.MAX_VALUE;   
        if (grid[i][j] == -1) return Integer.MAX_VALUE; 
        max = Math.max(max, grid[i][j]);
        int temp = grid[i][j];
        grid[i][j] = -1;
        int right = dfs(grid, i + 1, j, memo, max);
        int left = dfs(grid, i - 1, j, memo, max);
        int top = dfs(grid, i, j + 1, memo, max);
        int bottom = dfs(grid, i, j - 1, memo, max);
        int result = Math.min(Math.min(top, bottom),Math.min(left, right));
        grid[i][j] = temp;
        return result;
    }


    public int bfs(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] directions = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        minHeap.offer(new int[] {grid[0][0], 0, 0});
        grid[0][0] = -1;
        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            int max = cell[0];
            int i = cell[1];
            int j = cell[2];
            if (i == grid.length - 1 && j == grid.length - 1)
                return max;
            for (int[] dir : directions) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x < 0 || y < 0 || x == grid.length || y == grid.length) continue;
                if (grid[x][y] == -1) continue;
                minHeap.offer(new int[] {Math.max(max, grid[x][y]), x, y});
                grid[x][y] = -1;
            }
        }
        return -1;
    }
}
