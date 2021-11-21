# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]):
        if not inorder: return None
        left = 0
        find = 0
        node = postorder[-1]
        for i,v in enumerate(inorder):
            if v == node:
                find = i
        return TreeNode(node, 
                        self.buildTree(inorder[:find], postorder[:find]),
                        self.buildTree(inorder[find+1:], postorder[find:-1])
                       )