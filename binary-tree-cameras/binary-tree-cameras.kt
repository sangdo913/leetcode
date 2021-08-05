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
    enum class TYPE{
        NOTNEED, NEED, CAMERA
    }
    var hashMap = HashMap<TreeNode?, TYPE>()
    var r = TreeNode(0)

    fun minCameraCover(root: TreeNode?, first: Boolean = true): Int {
        if(root == null) {
            hashMap[null] = TYPE.NOTNEED
            return 0
        }
        if(first) {
            r = root
            hashMap[root] = TYPE.CAMERA
        }
        
        var sum = minCameraCover(root.left, false)
        sum += minCameraCover(root.right, false)
        
        var left = hashMap[root.left]
        var right = hashMap[root.right]
        return sum + if(left == TYPE.NEED || right == TYPE.NEED) {
            hashMap[root] = TYPE.CAMERA
            1
        }
        else if(left == TYPE.NOTNEED && right == TYPE.NOTNEED) {
            hashMap[root] = TYPE.NEED
            0
        }
        else {
            hashMap[root] = TYPE.NOTNEED
            0
        } + if(first && hashMap[r] == TYPE.NEED) 1 else 0 
    }
}