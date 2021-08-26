class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        var counter = HashMap<Int,Int>()
        nums.forEach {
            if(it in counter) counter[it] = counter[it]!!+1
            else counter[it] = 1
        }
        var a = counter.keys
        var li = ArrayList<Pair<Int,Int>>()
        counter.forEach{k,v ->li.add(Pair(v,k))}
        li.sortWith(Comparator{i,j->j.first - i.first})
        var res = IntArray(k)
        for(i in 0 until k) res[i] = li[i].second
        return res
    }
}