class Solution(object):
    def minInsertions(self, s):
        """
        :type s: str
        :rtype: int
        """
        # First loop over string s, and count number of open brackets and track min_insertion counter, if we find an '(', then increment open_counter, else if the next subsequent character in string is == ')' then we have a '))', so this implies we skip by adding i++ so we dont count the second ')' again. Else, if a singular ')' found we increment min_insertions. Then we check if there are any existing open brackets, if yes, then decrement open_count since we have accounted for it through inserting ')', else increment min_operations again to insert a '(' to balance the '))' pair.
        # At the end, return min_insertions + 2 * open_count, since for each remaining open bracket, we have to insert exactly 2 ')' characters.
        n = len(s)
        open_count = 0
        min_insertions = 0
        i = 0
        while i < n:
            ch = s[i]

            if ch == '(':
                open_count += 1
            else:
                if i + 1 < n and s[i + 1] == ')':
                    i += 1
                else:
                    min_insertions += 1
                
                if open_count > 0:
                    open_count -= 1
                else:
                    min_insertions += 1
            i += 1
        return min_insertions + (open_count * 2)

        
