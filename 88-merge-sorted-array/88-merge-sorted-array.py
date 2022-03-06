class Solution:
    def merge(self, nums1, m, nums2, n):
        l,r = m-1,n-1
        p = m + n -1
        while(p >= 0):
            le,ri = 0,0
            if l == -1: le = -0x3f3f3f3f
            else: le = nums1[l]

            if r == -1: ri = -0x3f3f3f3f
            else: ri = nums2[r]
            if le < ri: nums1[p] = ri;r-=1
            else: nums1[p] = le;l-=1
            p-=1