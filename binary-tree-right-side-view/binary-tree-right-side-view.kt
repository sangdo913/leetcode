/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        var Q:ArrayDeque<TreeNode> = ArrayDeque()
        if(root == null) return listOf()
        var res = ArrayList<Int>()
        Q.add(root)
        while(Q.isNotEmpty()){
            var cnt = Q.size
            res.add(Q.last().`val`)
            while(cnt!=0) {
                cnt--
                var now = Q.pollFirst()
                now.left?.let{Q.addLast(it)}
                now.right?.let{Q.addLast(it)}
            }
        }
        return res
    }
}