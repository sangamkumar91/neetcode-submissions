class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        int[] result = new int[temperatures.length];
        pq.offer(new int[] {
            temperatures[temperatures.length - 1],
            temperatures.length - 1
            }
        );
        for (int i = temperatures.length - 2 ; i >= 0 ; i--) {
            while (!pq.isEmpty() && pq.peek()[0] <= temperatures[i]) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                result[i] = pq.peek()[1] - i;
            }
            pq.offer(new int[] {temperatures[i], i});
        }
        return result;
    }
}
