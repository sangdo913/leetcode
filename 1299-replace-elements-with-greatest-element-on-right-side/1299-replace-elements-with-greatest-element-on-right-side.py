class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        dp = [-0x3f3f3f3f]*len(arr)
        dp[-1] = -1
        m = arr[-1]
        for i in range(len(arr)-2, -1,-1):
            dp[i] = m
            m = max(m, arr[i])
        return dp