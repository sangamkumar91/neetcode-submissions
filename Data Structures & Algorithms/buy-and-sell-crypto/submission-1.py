class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxm = float("-inf")
        result = float("-inf")
        for price in reversed(prices):
            maxm = max(price, maxm)
            result = max(result, maxm - price)

        return result





        