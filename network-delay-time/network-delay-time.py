from collections import defaultdict
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        kruscal = [[0x3f3f3f3f]*n for _ in range(n)]
        for i in range(n): 
            kruscal[k-1][k-1] = 0
        
        #1 번 따로넣기
        adj = [[] for _ in range(n)]
        cost = [[] for _ in range(n)]
        
        #2 번 같이 넣기
        adj2 = [[] for _ in range(n)]
        
        for a,b,t in times:
            kruscal[a-1][b-1] = t
            adj[a-1].append(b-1)
            cost[a-1].append(t)
            
            adj2[a-1].append((b-1,t))
        
        for l in range(n):
            for i in range(n):
                for j in range(n):
                    kruscal[i][j] = min(kruscal[i][l] + kruscal[l][j], kruscal[i][j])
                    
        print(kruscal[k-1])
        res = max(kruscal[k-1]) 
        return res if res < 0x3f3f3f3f else -1
        