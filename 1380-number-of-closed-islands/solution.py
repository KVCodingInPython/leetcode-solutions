class Solution(object):
    def closedIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        i = 1
        rows = len(grid)
        cols = len(grid[0])
        visit = [[False] * cols for n in range(rows)]
        count = 0

        # u, d, r, l = [1,0], [-1,0], [0,1], [0,-1]
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 0 and not visit[i][j] and self.bfs(i, j, rows, cols, grid, visit):
                    count += 1
        return count
        

    def bfs(self, x, y, rows, columns, grid, visit):
        q = deque([(x,y)])
        visit[x][y] = True
        is_closed = True

        dirx = [0, 1, 0, -1]
        diry = [-1, 0, 1, 0]

        while q:
            x, y = q.popleft()

            for i in range(4):
                r, c = x + dirx[i], y + diry[i]
                if r < 0 or r >= rows or c < 0 or c >= columns:
                    is_closed = False
                
                elif grid[r][c] == 0 and not visit[r][c]:
                    q.append([r,c])
                    visit[r][c] = True

        return is_closed

        # print(len(grid))
        # print(len(grid[i]))
        
