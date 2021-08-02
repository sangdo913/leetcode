class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var res = 0x3f3f3f3f
        nums.sort()
        for(i in nums.indices){
            var s = i +1
            var e = nums.lastIndex
            while(s < e){
                val sum = nums[i] + nums[s] + nums[e] - target
                if(Math.abs(sum) < Math.abs(res)) res = sum
                if(sum < 0) ++s  
                else --e
            }
        }
        return target + res
    }
}