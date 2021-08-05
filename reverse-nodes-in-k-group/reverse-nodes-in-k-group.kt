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
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var dummy = ListNode(-1)
        var cur: ListNode? = head
        var kth: ListNode? = cur!!.next
        var prev = dummy
        dummy.next = cur
        while(cur != null) {
            var ok = true
            kth = cur
            for(i in IntRange(1,k)) {
                if(kth == null) {
                    ok = false
                    break
                }
                kth = kth.next
            }
            if(ok) {
                var next = kth
                var nextPrev = cur
                for(i in IntRange(1,k)) {
                    var temp = cur!!.next
                    prev.next = cur
                    cur!!.next = kth
                    kth = cur
                    cur = temp
                }
                prev = nextPrev
                cur = next
            }
            else break
        }
        
        return dummy.next
    }
}