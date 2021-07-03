/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    fun copyRandomList(node: Node?): Node? {
        var conv = HashMap<Node?, Node?>()
        var head = node
        conv[null] = null
        while(head != null){
            conv[head] = Node(head.`val`)
            head = head.next
        }
        head= node
        while(head != null){
            conv[head]!!.next = conv[head?.next]
            conv[head]!!.random = conv[head?.random]
            head = head.next
        }
        return conv[node]
    }
}