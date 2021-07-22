class Solution {
    fun partitionDisjoint(nums: IntArray): Int {
        var v = IntArray(nums.size)   
        var mmax = 0x3f3f3f3f
        for(j in nums.lastIndex downTo 0){
            v[j] = Math.min(mmax, nums[j])
            mmax = v[j]
        }
        var mmin = nums[0]
        for(i in nums.indices) {
            if(mmin <= v[i]) return if(i == 0) 1 else i
            mmin = Math.max(nums[i], mmin)
        }
        return nums.size
    }
}