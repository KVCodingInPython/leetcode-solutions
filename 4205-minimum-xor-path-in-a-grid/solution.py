class Solution(object):
    def minCost(self, grid):
        rows = len(grid)
        cols = len(grid[0])
        
        # Use an integer bitmask instead of a Python set. 
        # Bit position 'x' being 1 means the XOR sum 'x' is reachable.
        dp = [0] * cols
        dp[0] = 1 << grid[0][0]
        
        for i in range(rows):
            for j in range(cols):
                if i == 0 and j == 0:
                    continue
                
                # Combine reachability from above (dp[j]) and left (dp[j-1])
                mask = dp[j]
                if j > 0:
                    mask |= dp[j - 1]
                
                val = grid[i][j]
                
                # Efficiently XOR 'val' with every active state using bit manipulation
                new_mask = 0
                temp = mask
                while temp:
                    # Extract the lowest set bit (the current reachable XOR value)
                    bit = (temp & -temp).bit_length() - 1
                    # Shift it to its new XOR result position
                    new_mask |= 1 << (bit ^ val)
                    # Clear the lowest bit to move to the next one
                    temp &= temp - 1
                    
                dp[j] = new_mask
                
        # The minimum XOR value is the position of the lowest set bit in the final mask
        final_mask = dp[-1]
        return (final_mask & -final_mask).bit_length() - 1
                
                

                    

        
