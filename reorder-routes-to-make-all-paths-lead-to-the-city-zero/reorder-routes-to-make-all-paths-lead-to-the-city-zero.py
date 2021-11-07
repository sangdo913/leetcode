class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        froms = [[] for _ in range(n)]
        tos = [[] for _ in range(n)]
        for a,b in connections:
            froms[a].append(b)
            tos[b].append(a)
        def reorder(now, prev):
            res = 0
            for i in tos[now]:
                if i != prev: res += reorder(i,now)
            for i in froms[now]: 
                if i != prev: res += 1 + reorder(i, now)
            return res
        return reorder(0,-1)
                
        