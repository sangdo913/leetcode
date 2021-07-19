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
    fun invertTree(root: TreeNode?): TreeNode? {
        if(root == null) return null
        var right = root.right?.let{invertTree(it)} ?: null
        var left = root.left?.let{invertTree(it)} ?: null
        root.left = right
        root.right = left
        return root
    }
}