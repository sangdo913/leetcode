class Node(var v: Int=0, var left:Node? = null, var right: Node? = null)


class Solution {
    fun findMaximumXOR(nums: IntArray): Int {
        var p = Node(0)
        for(v in nums) {
            var cur = p
            for(i in 31 downTo 0) {
                var b = 1 shl i
                if((b and v)!= 0) {
                    if(cur.right == null){
                        cur.right = Node(v)
                    }
                    cur = cur.right!!
                }
                else {
                    if(cur.left == null){
                        cur.left = Node(v)
                    }
                    cur = cur.left!!
                }
            }
        }
        var res = 0
        for(v in nums) {
            var cur = p
            for(i in 31 downTo 0){
                var b = (1 shl i)
                
                if((b and v) == 0) {
                    cur = if(cur.right == null) cur.left!! else cur.right!!
                }
                else {
                    cur = if(cur.left == null) cur.right!!  else cur.left!!
                }
            }
            res = Math.max(res, v xor cur.v)
        }
        return res      
    }
}