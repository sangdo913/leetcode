import java.util.*
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        var c = nums.sortedWith(Comparator{i,j-> i-j})
        var range = 0.. nums.lastIndex
        var res = ArrayList<List<Int>>()
        var prev = 0x3f3f3f3f
        for(i in range) {
            if(c[i] == prev) continue
            var l = i+1
            var r = nums.lastIndex
            while(l < r) {
                var sum = c[i] + c[l] + c[r]
                if(sum == 0) res.add(listOf(c[i],c[l],c[r]))
                var tempL =c[l]
                var tempR = c[r]
                if(sum < 0) while(l < r && tempL == c[l]) ++l
                else while(l < r && tempR == c[r]) --r
            }
            prev = c[i]
        }
        return res
    }
}