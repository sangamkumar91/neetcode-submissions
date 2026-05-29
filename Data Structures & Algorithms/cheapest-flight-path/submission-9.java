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
            System.out.println(Arrays.toString(minCosts));
            System.out.println(size);
            for (int i = 0; i < size; i++) {
                int[] source = pq.pollLast();
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
        System.out.println(pq.size());
        while(!pq.isEmpty()) {
            int[] source = pq.pollLast();
            System.out.println(Arrays.toString(source));
            if (source[0] == dst) {
                minCosts[source[0]] = Math.min(minCosts[source[0]], source[1]);
            };
        }
        System.out.println(Arrays.toString(minCosts));
        return minCosts[dst] == Integer.MAX_VALUE ? -1 : minCosts[dst];
    }
}
