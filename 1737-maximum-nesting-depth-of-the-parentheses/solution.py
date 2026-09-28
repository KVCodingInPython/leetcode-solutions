class Solution:
    def maxDepth(self, s: str) -> int:
        depth = 0
        max_depth = 0
        n = len(s)
        for i in range(n):
            if s[i] == '(':
                depth += 1
            elif s[i] == ')':
                max_depth = max(depth, max_depth)
                depth -= 1
            
        return max_depth
