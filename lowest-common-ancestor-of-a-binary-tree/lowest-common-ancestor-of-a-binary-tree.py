# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        dic = {}
        parent = {}
        Q = deque([root])
        dic[root] = 0
        depth = 0
        
        while Q:
            cnt = len(Q)
            while cnt > 0:
                cnt-=1
                now = Q.popleft()
                dic[now] = depth
                if now.left: 
                    parent[now.left] = now
                    Q.append(now.left)
                if now.right: 
                    parent[now.right] = now
                    Q.append(now.right)  
            depth += 1
            
        f,s = (p,q) if dic[p] > dic[q] else (q,p)
        while dic[f] != dic[s]:
            f = parent[f]
        while f != s:
            f,s = parent[f], parent[s]
        
        return f