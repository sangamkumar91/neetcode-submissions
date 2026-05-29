class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[amount + 1][coins.length];
        return helper(amount, coins, 0, memo);

    }
    public int helper(int amount, int[] coins, int index, int[][] memo) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        if (memo[amount][index] != 0) return memo[amount][index];
        int result = 0;
        for (int i = index; i < coins.length ; i++) {
            result = result + helper(amount - coins[i], coins, i, memo);
        }
        memo[amount][index] = result;
        return result;
        
    }
}
