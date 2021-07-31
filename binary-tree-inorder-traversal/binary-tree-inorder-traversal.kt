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
    var res = ArrayList<Int>()
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if(root == null) return res
        inorderTraversal(root.left)
        res.add(root!!.`val`)
        return inorderTraversal(root.right)
    }
}