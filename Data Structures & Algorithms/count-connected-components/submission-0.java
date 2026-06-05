class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Integer>> adj = new HashMap();
        for (int[] edge : edges) {
            adj.putIfAbsent(edge[0], new ArrayList());
            adj.putIfAbsent(edge[1], new ArrayList());
            adj.get(edge[1]).add(edge[0]);
            adj.get(edge[0]).add(edge[1]);
        }
        int result = 0;
        for (int i = 0 ; i < n; i++) {
            if (visited[i]) continue;
            result++;
            dfs(i, adj, visited);
        }
        return result;
    }

    public void dfs(int i , HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j : adj.getOrDefault(i, new ArrayList<>())) {
            dfs(j, adj, visited);
        }
    }
}
