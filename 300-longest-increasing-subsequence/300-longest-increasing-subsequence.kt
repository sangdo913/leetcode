class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        var arr = IntArray(nums.size)
        var size = 0
        for(v in nums){
            var s = 0
            var e =size
            while(s < e){
                var m = (s+e)/2
                if(arr[m] < v) {
                    s = m + 1
                }
                else e = m
            }
            arr[s] = v
            if(s == size){
                size++
            }
        }
        return size
    }
}