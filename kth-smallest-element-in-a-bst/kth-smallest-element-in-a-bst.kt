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
    var res = TreeNode(-1)
    
    fun getNum(root: TreeNode?, k: Int): Int {
        if(root == null) return 0
        var left = getNum(root.left, k)
        if(left+1 == k) res = root
        return left + getNum(root.right, k - left - 1) + 1
    }
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        getNum(root, k)
        return res.`val`
    }
}