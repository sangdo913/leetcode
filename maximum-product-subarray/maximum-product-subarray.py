class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        zero_num = [int(i == 0) for i in nums]
        all_mul = [i for i in nums]
        
        res = -0x80000000
        mul = 1
        for i in range(len(nums)):
            mul *= nums[i]
            res = max(res, mul)
            mul = 1 if mul == 0 else mul
            
        nums = nums[::-1]
        mul = 1
        for i in range(len(nums)):
            mul *= nums[i]
            res = max(res, mul)
            mul = 1 if mul == 0 else mul
            
        return res