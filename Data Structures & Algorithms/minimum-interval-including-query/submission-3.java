class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        // Sort Queries and store the original index
        List<int[]> indexedQuery = new ArrayList();
        for (int i = 0; i < queries.length; i++) {
            indexedQuery.add(new int[] {queries[i], i});
        }

        Collections.sort(indexedQuery, (a,b) -> a[0] - b[0]);

        // Sort intervals by startime.
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        PriorityQueue<int[]> activeWindows = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        int i = 0;
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        // For each query, add the active windows in the PQ (sorted by length) and remove the old inactive windows.
        for (int[] q : indexedQuery){
            while (i < intervals.length && q[0] >= intervals[i][0]) {
                activeWindows.offer(new int[] {
                    (intervals[i][1] - intervals[i][0] + 1),
                    intervals[i][1]
                });
                i++;
            }
            while (!activeWindows.isEmpty() && q[0] > activeWindows.peek()[1])
                activeWindows.poll();
            
            if (!activeWindows.isEmpty()) {
                result[q[1]] = activeWindows.peek()[0];
            }
        }


        return result;
    }
}