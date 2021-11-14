class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        now = 0x3f3f3f3f
        profit = 0
        for i in prices:
            profit = max(profit,i - now)
            now = min(i, now)
        return profit
        