class Solution {
    fun minWindow(s: String, t: String): String {
        var flag = 0
        var cnt = IntArray(256)
        t.forEach {
            var v = it.toInt()
            if(cnt[v] == 0) flag++
            cnt[it.toInt()]++
        }
        
        var j = 0
        var res = 0x3f3f3f3f
        var ret = ""
        
        for(i in s.indices) {
            var v = s[i].toInt()
            cnt[v]--
            if(cnt[v] == 0) {
                flag--
            }
            
            if(flag == 0) {
                if(i-j+1 < res) {
                    ret = s.substring(j,i+1)
                    res = i-j+1
                }
            }
            while(j <= i && flag == 0) {
                if(i-j+1 < res) {
                    ret = s.substring(j,i+1)
                    res = i-j+1
                }
                var a = s[j].toInt()
                if(cnt[a] == 0) flag++
                cnt[a]++
                ++j
            }
        }
        return ret
    }
}