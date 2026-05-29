class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.putIfAbsent(flight[0], new ArrayList<>());
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        int[] minCosts = new int[n];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        ArrayDeque<int[]> pq = new ArrayDeque<>();
        pq.offerFirst(new int[] {src, 0});
        while(!pq.isEmpty() && k >= 0) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                int[] source = pq.pollLast();
                // Dont explore path if minimum cost already there
                if (source[1] >= minCosts[source[0]]) continue;
                if (source[1] < minCosts[source[0]])
                {
                    minCosts[source[0]] = source[1];
                };
                if (!adj.containsKey(source[0])) continue;
                for (int[] dest : adj.get(source[0])) {
                    pq.offerFirst(new int[] {dest[0], source[1] + dest[1]});
                }
            }
            k--;
        }
        // After all stops over, loop once more through destinations.
        while(!pq.isEmpty()) {
            int[] stop = pq.pollLast();
            if (stop[0] == dst) {
                minCosts[stop[0]] = Math.min(minCosts[stop[0]], stop[1]);
            };
        }
        return minCosts[dst] == Integer.MAX_VALUE ? -1 : minCosts[dst];
    }
}
