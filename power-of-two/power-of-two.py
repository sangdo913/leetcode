class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        s,e = 0,32
        while s < e:
            m = (s+e)//2
            if (1 << m) == n: return True
            if (1<<m) < n:
                s = m+1
            else:
                e = m
        return False
        