# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        last = root
        adj = dict()
        Q = deque([last])
        while Q:
            now = Q.popleft()
            last = now
            if now.left:
                adj[now.left] = now
                Q.append(now.left)
            if now.right:
                adj[now.right] = now
                Q.append(now.right)
        cnt = 0
        Q = deque([last])
        chk = set()
        while Q:
            remain = len(Q)
            while remain:
                remain-=1
                now = Q.popleft()
                chk.add(now)
                
                if now.left and now.left not in chk:
                    Q.append(now.left)
                if now.right and now.right not in chk:
                    Q.append(now.right)
                if now in adj.keys() and adj[now] not in chk:
                    Q.append(adj[now])
                    
            cnt+=1
            
        return cnt-1 
        