class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer> ((a, b) -> {
            return b - a;
        });

        for (int s: stones)
        pq.offer(s);

        while (pq.size() > 1) {
            int i = pq.poll();
            int j = pq.poll();

            if (i == j) continue;
            pq.offer(Math.abs(i - j));
        }
        if (pq.size() == 0) return 0;
        return pq.poll();
    }
}
