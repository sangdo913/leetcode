class Solution {
    var res = ArrayList<List<Int>>()
    fun combGet(candidates: IntArray, arr: ArrayDeque<Int>, t: Int, j: Int): ArrayList<List<Int>> {
        if(t == 0) {
            res.add(arr.toList())
            return res
        }
        else if(t < 0) return res
        if(j == candidates.size) return res
        var num = 0
        var sum = 0
        combGet(candidates, arr, t, j+1)
        while(sum < t) {
            num++
            sum+= candidates[j]
            arr.addLast(candidates[j])
            combGet(candidates, arr, t-sum, j+1)
        }
        while(num != 0) {
            num--
            arr.pollLast()
        }
        return res
    }
        
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        res.clear()
        return combGet(candidates, ArrayDeque<Int>(), target, 0)
    }
}