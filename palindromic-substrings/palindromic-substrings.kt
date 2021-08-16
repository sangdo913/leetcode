class Solution {
    fun countSubstrings(s: String): Int {
        var res = 0
        var ispelin = Array(s.length){BooleanArray(s.length){false}}
        for(i in 0 until s.length){
            ispelin[i][i] = true
            res++
        }
        for(i in 0 until s.lastIndex) {
            ispelin[i][i+1] = s[i] == s[i+1]
            res += if(ispelin[i][i+1]) 1 else 0
        }
        for(k in 2 until s.length) {
            for(i in 0 until s.length-k) {
                if(s[i] == s[i+k] && ispelin[i+1][i+k-1]) {
                    ispelin[i][i+k] = true
                    res++
                }
            }
        }
        return res
    }
}