class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        var bit = 0
        var res = ArrayList<ArrayList<Int>>()
        for(i in 0 until 1.shl(nums.size)) {
            bit = i
            var arrayList = ArrayList<Int>()
            for(j in nums.indices){
                if(bit.shr(j).and(1) != 0) {
                    arrayList.add(nums[j])
                }
            }
            res.add(arrayList)
        }
        return res
    }
}