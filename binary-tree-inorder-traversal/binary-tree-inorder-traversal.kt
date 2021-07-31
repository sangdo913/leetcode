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
    fun inorderTraversal(root: TreeNode?): List<Int> {
        var res = ArrayList<Int>()
        var stack = Stack<TreeNode>()
        var cur = root

        while(true) {
            if(cur != null){
                stack.add(cur)
                cur = cur.left
            }
            else {
                if(stack.isEmpty()) break
                cur = stack.pop()
                res.add(cur.`val`)
                cur = cur.right
            }
        }
        
        return res
    }
}
