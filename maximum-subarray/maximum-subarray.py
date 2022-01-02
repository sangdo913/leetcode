class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0]*n
        s = 0
        res = -0x3f3f3f3f
        for v in nums:
            s += v
            res = max(s,res)
            if s < 0: s = 0
        return res