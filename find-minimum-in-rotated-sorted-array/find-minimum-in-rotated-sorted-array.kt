class Solution {
    fun findMin(nums: IntArray): Int {
        var s = 0
        var e = nums.size
        while(s < e){
            var m = (s+e)/2
            if(nums[m] < nums[0]){
                e = m
            }
            else s = m+1
        }
        return if(e == nums.size) nums[0] else nums[e]
    }
}