# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        if root == None: return 0
        dic = {}
        cnt = 0
        Q = deque()
        Q.append(root)
        while Q:
            now = Q.popleft()
            dic[now] = cnt
            cnt+=1
            if now.left: Q.append(now.left)
            if now.right: Q.append(now.right)
            
        dp = [[-1]*2 for _ in range(cnt)]
        
        def dfs(node, robbed):
            if node == None: return 0
            hid = dic[node]
            if(dp[hid][robbed] != -1): return dp[hid][robbed]
            dp[hid][robbed] = 0
            left,right = dfs(node.left,0), dfs(node.right, 0)
            
            if(robbed ==0):
                left = max(left, dfs(node.left, 1))
                right = max(right, dfs(node.right, 1))
        
            dp[hid][robbed] = left+right + (node.val if robbed == 1 else 0)
            return dp[hid][robbed]
            
        return max(dfs(root, 0), dfs(root,1))
        