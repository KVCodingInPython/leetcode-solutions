class Solution(object):
    def minOperations(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        zero = nums.index(0)
        
        # Helper function to check if a valid cyclic pattern exists
        def check(step):
            for i in range(1, n):
                prev = (zero + (i - 1) * step) % n
                curr = (zero + i * step) % n
                if nums[prev] > nums[curr]:
                    return False
            return True
            
        ans = float('inf')
        
        # Pattern 1: Increasing sequence (step = 1)
        if check(1):
            ans = min(ans, zero)           # Direct rotations
            ans = min(ans, n - zero + 2)   # Reverse -> Rotate -> Reverse
            
        # Pattern 2: Decreasing sequence (step = -1)
        if check(-1):
            ans = min(ans, zero + 2)       # Rotate -> Reverse
            ans = min(ans, n - zero)       # Reverse -> Rotate
            
        return ans if ans != float('inf') else -1

        

