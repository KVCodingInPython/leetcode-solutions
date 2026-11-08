class Solution:
    def countServers(self, grid: list[list[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        row_counts = [0] * rows
        cols_counts = [0] * cols
        communicate_count = 0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1:
                    row_counts[i] += 1
                    cols_counts[j] += 1

        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1:
                    if row_counts[i] > 1 or cols_counts[j] > 1:
                        communicate_count += 1

        return communicate_count



        
