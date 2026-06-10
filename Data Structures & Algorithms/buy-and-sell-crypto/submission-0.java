class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int result = Integer.MIN_VALUE;
        for (int i = prices.length - 1 ; i >= 0 ; i--) {
            int price = prices[i];
            max = Math.max(price, max);
            result = Math.max(result, max - price);
        }

        return result;
    }
}
