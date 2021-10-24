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
    var n = 0
        fun makeTree(preorder: IntArray, inorder:IntArray, l: Int, r: Int): TreeNode?{
            if(l >= r) return null
            if(n == inorder.size) return null
            var node = preorder[n]
            n++
            var i = l
            while(i < r && inorder[i] != node) ++i
            var res = TreeNode(node)
            res.left = makeTree(preorder,inorder, l, i)
            res.right = makeTree(preorder, inorder, i+1, r)
            return res
        }
        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            n= 0
            return makeTree(preorder,inorder, 0, preorder.size)
        }


}