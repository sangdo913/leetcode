class Solution:
    def permuteUnique(self, nums):
        return [list(i) for i in set(permutations(nums))]