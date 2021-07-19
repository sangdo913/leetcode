class Solution {
    var res = ArrayList<ArrayList<Int>>()
    fun permute(nums:IntArray, n: Int){
        if(n == nums.size) {
            var arr = ArrayList<Int>()
            nums.forEach{arr.add(it)}
            res.add(arr)
            return
        }
        for(i in n .. nums.lastIndex) {
            var t = nums[i]
            nums[i] = nums[n]
            nums[n]  =t
            permute(nums, n+1)
            t = nums[i]
            nums[i] = nums[n]
            nums[n] = t
        }
    }
    fun permute(nums: IntArray): List<List<Int>> {
        res.clear()
        permute(nums, 0)
        return res
    }
}