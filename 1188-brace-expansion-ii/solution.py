class Solution:
    def braceExpansionII(self, expression: str) -> list[str]:
        # -------------------------------------------------------------
        # SECTION 1: BASE CASE
        # A plain word with no braces or commas is already fully expanded.
        # -------------------------------------------------------------
        if '{' not in expression and ',' not in expression:
            return [expression]
        
        # -------------------------------------------------------------
        # SECTION 2: TOP-LEVEL UNIONS (Commas at depth 0)
        # Lowest precedence: Handle top-level commas first.
        # -------------------------------------------------------------
        depth = 0
        for i, char in enumerate(expression):
            if char == '{':
                depth += 1
            elif char == '}':
                depth -= 1
            elif char == ',' and depth == 0:
                left_res = self.braceExpansionII(expression[:i])
                right_res = self.braceExpansionII(expression[i + 1:])
                return sorted(list(set(left_res) | set(right_res)))

        # -------------------------------------------------------------
        # SECTION 2.5: STRIP ENCLOSING BRACES
        # If the entire expression is wrapped in '{...}', peel them off.
        # -------------------------------------------------------------
        if expression[0] == '{':
            depth = 0
            for i, char in enumerate(expression):
                if char == '{':
                    depth += 1
                elif char == '}':
                    depth -= 1
                    if depth == 0:
                        if i == len(expression) - 1:
                            return self.braceExpansionII(expression[1:-1])
                        break

        # -------------------------------------------------------------
        # SECTION 3: TOP-LEVEL CONCATENATIONS (No top-level commas)
        # Higher precedence: Split into first block and remainder.
        # -------------------------------------------------------------
        if expression[0] != '{':
            first_block = expression[0]
            remainder = expression[1:]
        else:
            depth = 0
            end_index = 0
            for i, char in enumerate(expression):
                if char == '{':
                    depth += 1
                elif char == '}':
                    depth -= 1
                    if depth == 0:
                        end_index = i
                        break
            
            first_block = expression[:end_index + 1]
            remainder = expression[end_index + 1:]

        res1 = self.braceExpansionII(first_block)
        res2 = self.braceExpansionII(remainder)
        
        combined = []
        for w1 in res1:
            for w2 in res2:
                combined.append(w1 + w2)

        return sorted(list(set(combined)))
        

        
