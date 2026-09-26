class Solution:
    def evaluate(self, s: str, knowledge: list[list[str]]) -> str:
        # Convert knowledge list to a dictionary for fast lookups
        d = {k: v for k, v in knowledge}
        
        n = len(s)
        res = []
        i = 0
        
        while i < n:
            if s[i] == '(':
                # Find the closing bracket
                j = s.find(')', i)
                key = s[i + 1:j]
                # Append value from dict or '?' if missing
                res.append(d.get(key, '?'))
                i = j + 1
            else:
                res.append(s[i])
                i += 1
                
        return "".join(res)

        
