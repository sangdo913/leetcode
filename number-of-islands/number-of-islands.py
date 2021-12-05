class Solution:
    def numIslands(self,grid):
        li = []
        for i in grid:
            li.append([0]*len(i))
        di = (-1,0,1,0)
        dj = (0,1,0,-1)
        res = 0
        st = []
        for i,j in [(i,j) for i in range(len(grid)) for j in range(len(grid[0]))]:
            if li[i][j] == 1 or not int(grid[i][j]): continue
            res+=1
            li[i][j] = 1
            st.append((i,j))

            while st:
                i,j = st.pop()

                for nx, ny in [(i+di[d],j+dj[d])  for d in range(4) if 0<= i + di[d] < len(grid) and 0 <= j + dj[d] < len(grid[0])]:
                    if li[nx][ny] or not int(grid[nx][ny]): continue
                    li[nx][ny] = 1
                    st.append((nx,ny))

        return res