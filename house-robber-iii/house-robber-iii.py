# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        if root == None: return 0
        
        def rob_tree(root):
            if root == None: return [0,0]
            left = rob_tree(root.left)
            right = rob_tree(root.right)
            return [max([left[i] + right[j] for i in range(2) for j in range(2)]), root.val + left[0] + right[0]]
        
        return max(rob_tree(root))
        