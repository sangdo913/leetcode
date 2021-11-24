# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumEvenGrandparent(self, root: TreeNode, parent = 1, grandParent = 1) -> int:
        ret = 0
        if not root: 
            return 0
        if grandParent % 2 == 0: 
            ret += root.val
        
        return ret + self.sumEvenGrandparent(root.left, root.val, parent) + self.sumEvenGrandparent(root.right, root.val, parent)
        