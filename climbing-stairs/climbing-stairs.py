class Solution:
    
    def climbStairs(self, n: int) -> int:
        li = [0]*(n+1)
        li[0] = 1; li[1] = 1
        for i in range(2, n+1):
            li[i] = li[i-2] + li[i-1]
                
        return li[-1] 