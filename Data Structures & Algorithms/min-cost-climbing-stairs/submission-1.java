class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(helper(cost, 0), helper(cost, 1));
    }

    public int helper(int[] cost, int index) {
        if (index >= cost.length) return 0;
        if (memo[index] != -1) return memo[index];
        return memo[index] = cost[index] + Math.min(helper(cost, index + 1), helper(cost, index + 2));
    }
}
