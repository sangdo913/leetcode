class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        n = len(rooms)
        check = [0]*n
        remain = [i for i in rooms[0]]
        
        check[0] = 1
        for i in remain:
            check[i] = 1
            
        while remain:
            now = remain.pop()
            for nxt in rooms[now]:
                if check[nxt] == 0:
                    check[nxt] = 1
                    remain.append(nxt)
        
        return sum(check) == n