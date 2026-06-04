class Solution {
    HashSet<Integer> cycleNodes = new HashSet();
    int cycleNode = 0;

    // O(n) using list of nodes in the cycle
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] e: edges) {
            adj.putIfAbsent(e[0], new HashSet<Integer>());
            adj.putIfAbsent(e[1], new HashSet<Integer>());
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[adj.size()];
        dfs(visited, adj, 1, 0);
        System.out.println(cycleNodes.toString());
        for (int i = edges.length - 1; i >=0 ; i-- ) {
            int[] e = edges[i];
            if (cycleNodes.contains(e[0]) && cycleNodes.contains(e[1]))
                return e;
        }
        return new int[0];
    }

    public boolean dfs(boolean[] visited, HashMap<Integer, Set<Integer>> adj, int i, int parent) {
        if (visited[i - 1]) {
            cycleNode = i;
            return true;
        }
        visited[i - 1] = true;

        for (int n : adj.get(i)) {
            if (n == parent) continue;
            boolean x = dfs(visited, adj, n, i);
            if (x) {
                if (cycleNode == 0) return true;
                if (cycleNodes.contains(n)) cycleNode = 0;
                cycleNodes.add(n);
                return true;
            }
        }

        return false;
    }

    public int[] findRedundantConnection_O_N_Square(int[][] edges) {
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
