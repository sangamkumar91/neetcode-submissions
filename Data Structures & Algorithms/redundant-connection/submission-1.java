class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] e: edges) {
            adj.putIfAbsent(e[0], new HashSet<Integer>());
            adj.putIfAbsent(e[1], new HashSet<Integer>());
        }
        for (int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            boolean[] visited = new boolean[adj.size()];
            if (cycle(visited, adj, e[0], 0))
                return e;
        }
        return new int[0];
    }

    public boolean cycle(boolean[] visited, HashMap<Integer, Set<Integer>> adj, int i, int parent) {
        if (visited[i - 1]) {
            return true;
        }
        visited[i - 1] = true;

        for (int n : adj.get(i)) {
            if (n == parent) continue;
            boolean x = cycle(visited, adj, n, i);
            if (x) return true;
        }

        return false;
    }
}
