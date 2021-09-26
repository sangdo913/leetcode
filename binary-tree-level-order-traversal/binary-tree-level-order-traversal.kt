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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        var Q: Queue<TreeNode> = LinkedList()
        root?.let{Q.add(root)}
        var ret = ArrayList<List<Int>>()
        while(Q.isNotEmpty()) {
            var cnt = Q.size
            var level = ArrayList<Int>()
            while(cnt != 0) {
                cnt--
                var now = Q.poll()
                level.add(now.`val`)
                now.left?.let{Q.add(it)}
                now.right?.let{Q.add(it)}
            }
            ret.add(level)
        }
        
        return ret
    }
}