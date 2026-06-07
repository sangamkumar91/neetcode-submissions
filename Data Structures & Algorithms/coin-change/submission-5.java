class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return helper(coins, amount, memo);
    }
    public int helper(int[] coins, int amount, int[] memo) {       
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != Integer.MAX_VALUE) return memo[amount];
        for (int i = coins.length -1 ; i >= 0; i--) {
            int c = coins[i];
            int x = helper(coins, amount - c, memo);
            if (x == -1) continue;
            memo[amount] = Math.min(1 + x, memo[amount]);
        }
        memo[amount] = memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
        return memo[amount];
    }

}
