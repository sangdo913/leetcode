/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var fast = head
        if(head == null) return head
        var cnt = n
        var start = ListNode(-1)
        var dNode:ListNode? = start
        start.next = head
        while(cnt--!=0) fast = fast!!.next
        while(fast != null){
            dNode = dNode!!.next
            fast = fast!!.next
        }
        dNode?.next = dNode?.next?.next
        return start.next
    }
}