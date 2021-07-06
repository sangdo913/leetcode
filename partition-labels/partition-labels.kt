class Solution {
    fun partitionLabels(s: String): List<Int> {
        var st = IntArray(26){0x3f3f3f3f}
        var ed = IntArray(26){-1}
        for(i in s.indices){
            var c = s[i].toInt()-'a'.toInt()
            st[c] = Math.min(st[c], i)
            ed[c] = i
        }
        var cur = 0
        var res = ArrayList<Int>()
        var l = 0
        var r = -1
        for(i in s.indices){
            if(r == i) {
                res.add(r-l)
                l = r
            }
            r = Math.max(r, ed[s[i].toInt()-'a'.toInt()]+1)
        }
        res.add(r-l)
        return res
    }
}