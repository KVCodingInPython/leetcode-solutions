
from functools import cache
from typing import List

class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        m, n = len(grid), len(grid[0])
        
        # Optimization 1: Total path length is always m + n - 1. 
        # A valid parentheses string must have an even length.
        if (m + n - 1) % 2 != 0:
            return False
            
        # Optimization 2: Must start with '(' and end with ')'
        if grid[0][0] == ')' or grid[m-1][n-1] == '(':
            return False

        @cache
        def dfs(r: int, c: int, balance: int) -> bool:
            # Update balance based on current cell's character
            balance += 1 if grid[r][c] == '(' else -1
            
            # Pruning Condition: More close brackets than open ones
            if balance < 0:
                return False
            
            # Pruning Condition: Too many open brackets to close with remaining steps
            remaining_steps = (m - 1 - r) + (n - 1 - c)
            if balance > remaining_steps:
                return False

            # Base case: reached the bottom-right cell
            if r == m - 1 and c == n - 1:
                return balance == 0
            
            # Move Down or Move Right recursively
            down_valid = dfs(r + 1, c, balance) if r + 1 < m else False
            right_valid = dfs(r, c + 1, balance) if c + 1 < n else False
            
            return down_valid or right_valid

        # Start top-down traversal from (0, 0) with an initial balance of 0
        return dfs(0, 0, 0)

