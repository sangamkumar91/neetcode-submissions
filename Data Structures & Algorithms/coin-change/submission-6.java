class Solution {
    // Dont sort in descending. Its not necessary that greedy approch will give the right answer
    // Edge Case is this
    // coins = [1, 3, 4]
    // amount = 6

    // Greedy code tries 4 first:

    // 6 -> 4 + 1 + 1 = 3 coins

    // But optimal is:

    // 3 + 3 = 2 coins
    
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
