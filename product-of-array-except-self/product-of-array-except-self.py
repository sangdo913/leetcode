class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        zeroNum = 0
        mul = 1
        for v in nums:
            if v == 0: zeroNum+=1
            else: mul*= v
        if zeroNum >= 2: return [0]*len(nums)
        res = []
        for v in nums:
            if v == 0: res.append(mul)
            elif zeroNum == 1: res.append(0)
            else: res.append(mul//v)
            
        return res