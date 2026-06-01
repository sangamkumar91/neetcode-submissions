class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];
        });

        List<int[]> result = new ArrayList();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] head = result.get(result.size() - 1);

            if (current[0] > head[1]) {
                result.add(current);
                continue;
            }
            head[1] = Math.max(current[1], head[1]);
        }

        return result.toArray(new int[0][0]);
        
    }
}
