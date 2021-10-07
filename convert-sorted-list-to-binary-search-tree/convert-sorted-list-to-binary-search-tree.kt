/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
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
    fun sortedListToBST(head: ListNode?): TreeNode? {
        if(head == null) return null
        var prev: ListNode? = null
        var cur = head
        var cnt = 0
        while(cur != null) {
            cnt++
            cur = cur.next
        }
        var remain = 0
        cur = head
        prev = null
        while(remain < cnt / 2) {
            prev = cur
            cur = cur!!.next
            remain++
        }
        var node = TreeNode(cur!!.`val`)
        prev?.let{it.next = null}
        node.left = sortedListToBST(if(head == cur) null else  head)
        node.right = sortedListToBST(cur!!.next)
        return node
    }
}