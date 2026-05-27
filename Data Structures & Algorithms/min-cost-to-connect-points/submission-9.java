class Edge {
    int p1;
    int p2;
    int dist;
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points.length <= 1) return 0;
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>((a, b) -> {
            return a.dist - b.dist;
        });
        HashMap<Integer, List<Edge>> edgesPerNode = new HashMap();
        for (int i = 0; i < points.length; i++) {
            List<Edge> list = new ArrayList();
            edgesPerNode.put(i, list);
        }
        for (int i = 0; i < points.length; i++) {
            List<Edge> list = new ArrayList();
            for (int j = i + 1; j < points.length; j++){
                Edge e = new Edge();
                e.p1 = i;
                e.p2 = j;
                e.dist = dist(points, i, j);
                edgesPerNode.get(i).add(e);
                edgesPerNode.get(j).add(e);        
            }
        }
        HashSet<Integer> visited = new HashSet();
        int sum = 0;
        int edgesUsed = 0;
        queue.addAll(edgesPerNode.get(0));
        visited.add(0);
        while (edgesUsed < points.length - 1) {
            Edge e = queue.poll();
            if (visited.contains(e.p1) && visited.contains(e.p2)) continue;
            if (!visited.contains(e.p1)) {
                visited.add(e.p1);
                queue.addAll(edgesPerNode.get(e.p1));
            }
            if (!visited.contains(e.p2)) {
                visited.add(e.p2);
                queue.addAll(edgesPerNode.get(e.p2));
            }
            sum = sum + e.dist;
            edgesUsed++;
        }
        return sum;
    }
    public int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
}