class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var s = 0
        var znum = 0
        var res = 0
        for(i in nums.indices) {
            if(nums[i] == 0) znum++
            while(s < i && znum > k){
                if(nums[s] == 0) znum--
                ++s
            }
            if(znum <= k) res = Math.max(res, i-s+1)
        }
        return res
    }
}