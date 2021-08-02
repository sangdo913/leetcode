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
    fun sortedArrayToBST(nums: IntArray, s:Int = 0, e: Int = nums.size): TreeNode? {
        if(s >= e) return null
        var m = (s+e)/2
        var ret = TreeNode(nums[m])
        ret.left = sortedArrayToBST(nums, s, m)
        ret.right = sortedArrayToBST(nums,m+1,e)
        return ret
    }
}