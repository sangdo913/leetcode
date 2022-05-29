# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class printLIST:
    def __init__(self, node):
        self.n = node
    def __repr__(self):
        cur = self.n
        ret = 'node: '
        while cur:
            ret += str(cur.val) + ' '
            cur = cur.next
        return ret
    
    def __str__(self):
        return self.__repr__() 
        
def sortList2(head, l):
    if l <= 0: return None
    if l == 1: return head
    res = ListNode(next=head)
    cnt = 0
    cur = res
    while cnt < int(l/2):
        cnt+=1
        cur = cur.next

    h2 = cur.next
    cur.next = None
    h1 = sortList2(head, int(l/2)) 
    h2 = sortList2(h2, l-int(l/2))
    
    res.next = None
    back = res
    
    while h1 or h2:
        if(h2 == None or (h1 and h1.val < h2.val)):
            back.next = h1
            back = h1
            h1 = h1.next
            back.next = None
            
        else:
            back.next = h2
            back = h2
            h2 = h2.next
            back.next = None
        
    return res.next

class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        l = 0
        cur = head
        while cur:
            l+=1
            cur = cur.next
        return sortList2(head, l)
        