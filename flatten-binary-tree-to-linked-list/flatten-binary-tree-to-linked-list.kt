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
    fun flatten(root: TreeNode?): Unit {
        var left: TreeNode? = null
        var right: TreeNode? = null
        if(root == null) return
        var res = root
        while(res != null) {
            if(res.left != null) {
                var nxt = res!!.right
                right = res!!.left
                while(right!!.right != null) right = right!!.right
                right!!.right = nxt
                res!!.right = res!!.left
                res.left = null
            }
            res = res.right
        }
    }
}