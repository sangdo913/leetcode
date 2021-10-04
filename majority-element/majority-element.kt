class Solution {
    fun majorityElement(nums: IntArray): Int {
        var first = 0
        var res = nums[0]
        nums.forEach{
            if(res == it) first++
            else first--
            if(first < 0) {
                res = it
                first = 0
            }
        }
        return res
    }
}