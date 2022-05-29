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
    fun partition(head: ListNode?, x: Int): ListNode? {
        if(head == null) return null
        var lessNode:ListNode? =  null
        var greater:ListNode? = null
        var cur:ListNode? = head
        var prev:ListNode? = null
        var nxt:ListNode? = null
        var res:ListNode? = head
        
        while(cur != null) {
            nxt = cur.next
            if(cur.`val` >= x) {
                greater = greater ?: cur
                prev = cur
            }
            else{
                if(greater != null){
                    cur.next = if(lessNode == null){
                        res = cur
                        lessNode = cur
                        greater
                    }
                    else {
                        cur.next = lessNode.next
                        lessNode.next = cur
                        lessNode = cur
                        cur.next
                    }
                    prev?.next = nxt
                }
                else{
                    lessNode = cur
                }
            }
            
            cur = nxt
        }
        return res
    }
}