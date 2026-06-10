class Solution {
    HashMap<Integer, HashSet<int []>> adj = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {

        for (int i = 0 ; i < n ; i++) {
            adj.putIfAbsent(i + 1, new HashSet());
        }
        for (int[] time : times) {
            adj.get(time[0]).add(new int[] {time[1], time[2]});
        }

        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        dfs(k, visited, 0);
        int result = Integer.MIN_VALUE;
        for (int x : visited)
            if (x == Integer.MAX_VALUE) return -1;
            else result = Math.max(result, x);
        
        return result;
    }

    public void dfs(int i, int[] visited, int time) {
        if (visited[i - 1] <= time) return;
        visited[i - 1] = time;
        for (int[] edge : adj.get(i)) {
            dfs(edge[0], visited, time + edge[1]);
        }
    }
}
