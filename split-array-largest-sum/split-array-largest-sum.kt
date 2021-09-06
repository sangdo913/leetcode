class Solution {
    fun splitArray(nums: IntArray, m: Int): Int {
        var s = 0
        var e = 0x3f3f3f3f
        while(s < e){
            var mid = (s+e)/2
            var sum = 0
            var k = 0
            nums.forEach{
                if(it > mid) k = m+1
                if(sum + it > mid) {
                    ++k
                    sum = it
                } else sum+=it
            }
            ++k
            if(k <= m) e = mid
            else s = mid+1
        }
        return s
    }
}