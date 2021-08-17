var sum = Array(256){IntArray(0)}
class Solution {
    fun removeDuplicateLetters(s: String): String {
        for(i in 'a'.toInt() .. 'z'.toInt()) {
            sum[i] = IntArray(s.length)
        }
        var adj = Array(256){ArrayList<Int>()}
        var need = 0
        s.forEachIndexed {
            i,c ->
            sum[c.toInt()][i]++
            need += if(adj[c.toInt()].size == 0)1 else 0
            adj[c.toInt()].add(i)
        }
        for(i in 'a'.toInt() .. 'z'.toInt()) {
            for(j in 1 until sum[i].size) {
                sum[i][j] += sum[i][j-1]
            }
        }
        val sb = StringBuilder()
        var std = -1
        var cur = IntArray(256)
        var complete = HashSet<Int>()
        var cnt = need
        while(cnt != 0) {
            cnt--
            for(i in 'a'.toInt() .. 'z'.toInt()) {
                if(i in complete) continue
                while(cur[i] < adj[i].size && adj[i][cur[i]] <= std) cur[i]++
                if(cur[i] == adj[i].size) continue
                var num = 0
                var p = adj[i][cur[i]]
                for(j in 'a'.toInt() .. 'z'.toInt()) {
                    if(j in complete) continue
                    var v = sum[j][s.lastIndex] - if(p == 0) 0 else sum[j][p-1]
                    num += if(v > 0) 1 else 0 
                }
                if(num == need) {
                    sb.append(i.toChar())
                    complete.add(i)
                    std = p
                    break
                }
            }
            need--
        }
        return sb.toString()
    }
}