class NumArray:

    def __init__(self, nums: List[int]):
        self.sum = [0] * (len(nums)+1)
        self.n = len(nums)
        self.nums = nums
        
        for i in range(len(nums)):
            v = nums[i]
            idx = i+1
            
            while (idx <= self.n):
                self.sum[idx] += v
                idx += idx & -idx

    def update(self, index: int, val: int) -> None:
        diff = val - self.nums[index]
        self.nums[index] = val
        idx = index+1
        while idx <= self.n :
            self.sum[idx] += diff
            idx += idx & -idx

    def sumRange(self, left: int, right: int) -> int:
        idx = left
        res = 0
        while idx:
            res -= self.sum[idx]
            idx -= idx&-idx
        idx = right+1
        while idx:
            res += self.sum[idx]
            idx -= idx&-idx
        return res
        


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)