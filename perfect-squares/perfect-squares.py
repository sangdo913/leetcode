class Solution:
    def numSquares(self, n: int) -> int:
        dp = [0x3f3f3f3f]*(n+1)
        adj = []
        i = 1
        while i*i <= n:
            dp[i*i] = 1
            adj.append(i*i)
            i+=1
            
        for i in range(n+1):
            for j in adj:
                if i - j <= 0: break
                dp[i] = dp[i-j]+1 if dp[i-j] + 1 < dp[i] else dp[i]
        return dp[n]