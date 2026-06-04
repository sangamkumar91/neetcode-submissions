class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        HashMap<Integer, HashSet<Integer>> adj = new HashMap();
        for (int i = 0 ; i < n ; i++) {
           adj.putIfAbsent(i, new HashSet()); 
        }
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        if (hasCycle(visited, adj, 0, -1)) return false;

        for (boolean v : visited)
            if (!v) return false;

        return true;
    }

    public boolean hasCycle(boolean[] visited, HashMap<Integer, HashSet<Integer>> adj, int i, int parent) {
        if (visited[i]) return true;
        visited[i] = true;
        for (int n : adj.get(i)) {
            if (n == parent) continue;
            if (hasCycle(visited, adj, n, i))
                return true;
        }
        return false;
    }
}
