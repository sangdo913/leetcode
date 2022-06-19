class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var s = 0
        var e = nums.size
        var startIndex = 0
        var lastIndex =0
        while(s<e){
            startIndex = (s+e)/2
            if(nums[startIndex] < target) s = startIndex+1
            else e = startIndex
        }
        startIndex = s
        s = 0
        e = nums.size
        while(s < e){
            lastIndex = (s+e)/2
            if(nums[lastIndex] <= target) s = lastIndex+1
            else e = lastIndex
        }
        lastIndex = e

        return if(startIndex == lastIndex) intArrayOf(-1,-1) else intArrayOf(startIndex,lastIndex-1)
    }

}