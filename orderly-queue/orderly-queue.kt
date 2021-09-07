class Solution {
    fun orderlyQueue(s: String, k: Int): String {
        var ret = s
        if(k == 1) {
            for(i in s.indices) {
                var s1 = s.substring(i, s.length)
                var s2 = s.substring(0, i)
                var s3 = s1+s2
                if(ret > s3) {
                    ret = s3
                }
            }
        }
        else {
            var arr = s.toCharArray()
            Arrays.sort(arr)
            return String(arr)
        }
        return ret
    }
}