# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def toList(self, root, l):
        if not root: return
        self.toList(root.left,l)
        l.append(root.val)
        self.toList(root.right,l)
        
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        l = []
        self.toList(root, l)
        s = 0
        e = len(l)-1
        while s < e:
            if l[s] + l[e] == k: return True
            elif l[s] + l[e] < k: s+=1
            else: e-=1
        return False
