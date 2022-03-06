class Solution:
    def isPalindrome(self, head):
        n = 0
        cur = head
        while cur:
            n+=1
            cur = cur.next
        cur = head
        cnt = n//2
        while cnt:
            cur = cur.next
            cnt-=1
        prev = None
        while cur:
            nxt = cur.next
            cur.next = prev
            prev = cur
            cur = nxt
        cur = head
        while prev:
            if prev.val != cur.val:
                return False
            prev = prev.next
            cur = cur.next
        return True
