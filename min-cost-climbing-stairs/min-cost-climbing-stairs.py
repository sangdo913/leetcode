class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        dp = [0x3f3f3f3f] * (len(cost)+1)
        dp[0], dp[1] = 0,0
        print(dp)
        for i in range(2, len(dp)):
            dp[i] = min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1])
        return dp[-1]