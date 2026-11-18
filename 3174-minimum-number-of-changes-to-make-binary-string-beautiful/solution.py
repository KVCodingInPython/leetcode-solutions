class Solution:
    def minChanges(self, s: str) -> int:
        if all(c in '0' for c in s or c in '1' for c in s):
            return 0

        min_changes = 0
        i = 0
        while i < len(s) - 1:
            if s[i] != s[i + 1]:
                min_changes += 1

            i += 2
        
        return min_changes
            



        
