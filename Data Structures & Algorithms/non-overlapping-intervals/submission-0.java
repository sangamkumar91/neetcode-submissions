class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        });
        int[][] memo = new int[intervals.length][intervals.length];
        return backtrack(intervals, 0, 1, memo);
    }

    public int backtrack(int[][] intervals, int prev, int current, int[][] memo) {
        if (current == intervals.length) return 0;
        if (memo[prev][current] != 0) return memo[prev][current];
        int[] p = intervals[prev];
        int[] c = intervals[current];
        if (p[1] <= c[0]) {
            return backtrack(intervals, current, current + 1, memo);
        }
        memo[prev][current] = 1 + Math.min(
            backtrack(intervals, prev, current + 1, memo),
            backtrack(intervals, current, current + 1, memo)
        );
        return memo[prev][current];
    }
}
