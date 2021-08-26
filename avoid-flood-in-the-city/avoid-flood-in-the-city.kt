import java.util.*

class Solution {
    fun avoidFlood(rains: IntArray): IntArray {
        var cnt = HashMap<Int,Int>()
        var deques = rains.groupBy{it}.keys.map{
            it to ArrayDeque<Int>()
        }.toMap()
        rains.forEachIndexed{i,v->deques[v]!!.addLast(i)}
        deques.keys.forEach{deques[it]!!.addLast(0x3f3f3f3f)}
        var pq = PriorityQueue<Pair<Int,Int>>{i,j -> i.first - j.first}
        var chk = HashSet<Int>()
        var res = IntArray(rains.size)
        var st = ArrayDeque<Int>()
        var flood = false
        rains.forEachIndexed{
            i,v->
            res[i] = if(v == 0){
                if(pq.isNotEmpty()) {
                    var a = pq.poll().second
                    chk.remove(a)
                    a
                }
                else 1
            } else{
                if(v in chk) flood = true
                chk.add(v)
                while(deques[v]!!.peekFirst() <= i) deques[v]!!.pollFirst()
                pq.add(deques[v]!!.peekFirst() to v)
                -1   
            }
            
        }
        return if(flood) intArrayOf() else res
    }
}