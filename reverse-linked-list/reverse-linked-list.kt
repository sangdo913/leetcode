/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

/*
Time: O(n)
Space: O(1)
*/

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if(head == null) return null
        var last: ListNode? = null
        var cur = head!!
        while(cur.next != null) {
            var next = cur.next
            cur.next = last
            last = cur
            cur = next
        }
        cur.next = last
        return cur
    }
}