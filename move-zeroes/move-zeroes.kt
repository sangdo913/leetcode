class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var cnt = 0
        for(j in nums.indices) {
            if(nums[j] != 0){
                nums[cnt] = nums[j]
                cnt++
            }
            
        }
        for(i in cnt until nums.size) {
            nums[i] = 0
        }
    }
}