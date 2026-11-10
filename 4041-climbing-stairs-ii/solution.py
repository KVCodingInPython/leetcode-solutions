class Solution:
    def climbStairs(self, n: int, costs: List[int]) -> int:
        # DP memoisation but iterative approach looping through costs array
        a = b = c = 0
        for i in range(n):
            # We want the minimum cost for either 3 steps, 1 step or 2 steps and so these can be expressed as (a + (3 - 0) ^ 2), (b + (2 - 0) ^ 2), and (c + (1 - 0) ^ 2)
            a, b, c = b, c, min(a + 9, b + 4, c + 1) + costs[i]

        return c




        



    
