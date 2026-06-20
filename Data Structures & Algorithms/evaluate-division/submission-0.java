class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> adj = new HashMap<>();
        int i = 0;
        for (List<String> e : equations) {
            String src = e.get(0);
            String target = e.get(1);
            adj.putIfAbsent(src, new HashMap<>());
            adj.putIfAbsent(target, new HashMap<>());
            adj.get(src).put(target, values[i]);
            adj.get(target).put(src, 1/values[i]);
            i++;
        }
        i = 0;
        double[] result = new double[queries.size()];
        for (List<String> q : queries) {
            HashSet<String> visited = new HashSet<>();
            result[i] = dfs(q.get(0), q.get(1), visited, adj);
            i++;
        }
        return result;
    }
    public double dfs(String src, String target,
        HashSet<String> visited, HashMap<String, HashMap<String, Double>> adj)
    {
        if (!adj.containsKey(src) || !adj.containsKey(target)) return -1.0;
        if (src.equals(target))
            return 1.0;
        if (visited.contains(src)) return -1.0;
        visited.add(src);
        HashMap<String, Double> children = adj.get(src);
        for (String n : children.keySet()) {
            double x = dfs(n, target, visited, adj);
            if (x != -1.0) return children.get(n) * x;
        }
        return -1.0;
    }
}