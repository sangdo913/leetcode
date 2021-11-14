class Solution:
    def maxArea(self, height: List[int]) -> int:
        s, e = 0, len(height)-1
        res = 0
        while s < e:
            res = max(res, (e-s)*min(height[s], height[e]))
            if height[s] > height[e]: e-=1
            else: s+=1
        return res
        