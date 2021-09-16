class Solution:
    def cycle(self, nums, chk, i, d):
        if chk[i] == 1: return d
        chk[i] = 1
        return self.cycle(nums, chk, nums[i], d+1)
        
        
        
    def arrayNesting(self, nums: List[int]) -> int:
        chk = [0]*len(nums)
        answer = 0
        for i in range(0, len(nums)):
            if chk[i] == 0:
                answer = max(answer, self.cycle(nums, chk, i,0))
        return answer
        
        
        