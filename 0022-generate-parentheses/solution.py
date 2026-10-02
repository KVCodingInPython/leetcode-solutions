class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        # 1. Calculate the exact size needed (nth Catalan Number)
        total_combinations = 1
        for i in range(1, n + 1):
            total_combinations = int(total_combinations * (4 * i - 2) / (i + 1))
        
        # 2. Pre-allocate the fixed-size array space
        self.s = [None] * total_combinations
        self.index = 0  # Manual array pointer tracker
        
        # 3. Fire the backtracking recursion
        self.recurse(n, n, "")
        return self.s

    def recurse(self, open_count: int, close_count: int, output: str) -> None:
        # Base Case: Valid combination completed
        if open_count == 0 and close_count == 0:
            # Insert directly into the pre-allocated slot
            self.s[self.index] = output
            self.index += 1  # Shift our manual pointer forward
            return
        
        # Choice 1: Add an open parenthesis
        if open_count != 0:
            self.recurse(open_count - 1, close_count, output + "(")
    
        # Choice 2: Add a closing parenthesis
        if open_count < close_count:
            self.recurse(open_count, close_count - 1, output + ")")

