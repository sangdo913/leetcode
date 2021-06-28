class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = {}
        for i,v in enumerate(nums):
            if target-v in dic: return [i,dic[target-v]]
            dic[v] = i
