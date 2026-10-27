class Solution(object):
    def createGrid(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: List[str]
        """
        grid = [["#" for _ in range(n)] for _ in range(m)]
        # Starting from top-left cell (0,0)

        # 2. Open the entire first row (move all the way right)
        for j in range(n):
            grid[0][j] = "."
            
        # 3. Open the entire last column (move all the way down)
        for i in range(m):
            grid[i][n - 1] = "."
        
        result = ["".join(row) for row in grid]
        return result
        
