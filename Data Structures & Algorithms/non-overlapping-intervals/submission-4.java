class Solution {
    // Best solution
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
          return 0;
        }
        Arrays.sort(intervals, (x, y) -> x[1] - y[1]);
        int totalNonOverlapCount = 1;
        int prevNonOverlapIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
          //if it is not overlapping with maxIndex, that means it will not overlapp with any of the other indexes that not overlap with max index as array is sorted
          if (!isOverlapping(intervals[prevNonOverlapIndex], intervals[i])) {
              totalNonOverlapCount++;
              prevNonOverlapIndex = i;
          }
        }
        
        return intervals.length - totalNonOverlapCount;
    }

    // Backtrack
    public int eraseOverlapIntervals_TIME_O_N_Square(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        });

        // int[][] memo = new int[intervals.length][intervals.length];
        // return backtrack_O_n_square_space(intervals, 0, 1, memo);

        int[] memo = new int[intervals.length];
        return intervals.length - backtrack_O_n_space(intervals, 0, memo);

    }

    // Calculates min removal for  non overlap
    public int backtrack_O_n_square_space(int[][] intervals, int prev, int current, int[][] memo) {
        if (current == intervals.length) return 0;
        if (memo[prev][current] != 0) return memo[prev][current];
        int[] p = intervals[prev];
        int[] c = intervals[current];
        if (p[1] <= c[0]) {
            return backtrack_O_n_square_space(intervals, current, current + 1, memo);
        }
        memo[prev][current] = 1 + Math.min(
            backtrack_O_n_square_space(intervals, prev, current + 1, memo),
            backtrack_O_n_square_space(intervals, current, current + 1, memo)
        );
        return memo[prev][current];
    }

    // Calculates max count in non overlap
    public int backtrack_O_n_space(int[][] intervals, int current, int[] memo) {
        if (current == intervals.length - 1) return 1;
        if (memo[current] != 0) return memo[current];
        int[] c = intervals[current];
        int[] n = intervals[current + 1];
        // 1. Non overlapping
        if (n[0] >= c[1]) {
            memo[current] = 1 + backtrack_O_n_space(intervals, current + 1, memo);
        } else {
            // 2. OverLapping
            // 2.1 Skip current
            memo[current] = backtrack_O_n_space(intervals, current + 1, memo);

            // 2.2 Include current
            for (int i = current + 1; i < intervals.length ; i++) {
                int[] next = intervals[i];
                if (next[0] >= c[1]) {
                    memo[current] =  Math.max(memo[current], 1 + backtrack_O_n_space(intervals, i, memo));
                    break;
                }
            }
        }
        return memo[current];
    }

    public boolean isOverlapping(int[] i, int[] j) {
        return i[1] > j[0];
    }
}
