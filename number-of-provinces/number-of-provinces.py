class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        
        chk = [0]*n
        adj = [[] for _ in range(n)]
        for i in range(n):
            for j in range(n):
                if isConnected[i][j]:
                    adj[i].append(j)
                    adj[j].append(i)
        
        def dfs(now):
            chk[now] = 1
            for nxt in adj[now]:
                if chk[nxt] == 0:
                    dfs(nxt)
        
        res = 0
        for i in range(n):
            if chk[i] == 0:
                dfs(i)
                res+=1
                
        return res