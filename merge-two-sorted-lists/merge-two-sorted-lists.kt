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
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var h1 = l1
        var h2 = l2
        var head = ListNode(0)
        var init = head
        while(h1 !=null || h2 != null) {
            var n1 = if(h1 == null) 0x3f3f3f3f else h1.`val`   
            var n2 = if(h2 == null) 0x3f3f3f3f else h2.`val`
            if(n1 < n2) {
                head.next = h1
                h1 = h1!!.next
            }
            else {
                head.next = h2
                h2 = h2!!.next
            }
            head = head.next
            head.next = null
        }
        return init.next
    }
}