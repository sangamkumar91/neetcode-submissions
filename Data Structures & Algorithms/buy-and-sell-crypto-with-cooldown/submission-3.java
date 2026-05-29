class Solution {
    int result = 0;
    public int maxProfit(int[] prices) {
        int[][] memo = new int[2][prices.length];
        return helper(1, prices, 0, memo);
    }

    public int helper (int canBuy, int[] prices, int i, int[][] memo) {
        if (i >= prices.length) {
            return 0;
        }
        if (memo[canBuy][i] != 0) return memo[canBuy][i];

        // Skip
        int profit = helper(canBuy, prices, i + 1, memo);

        if (canBuy == 0) {
            // sell
            profit = Math.max(
                profit,
                // Balance increases on selling
                prices[i] + helper(1, prices, i + 2, memo)
            );
        } else {

            profit = Math.max(
                profit,
                // Balance decreaes on buying
                helper(0, prices, i + 1, memo) - prices[i]
            );
        }
        memo[canBuy][i] = profit;
        return profit;
    }
}
