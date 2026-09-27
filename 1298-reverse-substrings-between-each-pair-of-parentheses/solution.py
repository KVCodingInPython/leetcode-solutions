class Solution:
    def reverseParentheses(self, s: str) -> str:
        n = len(s)
        pair = [0] * n
        stack = []

        for i, char in enumerate(s):
            if char == '(':
                stack.append(i)
            elif char == ')':
                open_idx = stack.pop()
                pair[open_idx] = i
                pair[i] = open_idx
        # Pass 2: Traverse using wormholes in O(N)
        result = []
        curr = 0
        direction = 1  # 1 for right, -1 for left

        while curr < n:
            if s[curr] in '()':
                curr = pair[curr]    # Teleport to matching bracket
                direction = -direction  # Reverse walking direction
            else:
                result.append(s[curr])
            
            curr += direction

        return "".join(result)
          
       
