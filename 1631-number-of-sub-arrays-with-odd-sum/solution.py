class Solution(object):
    def numOfSubarrays(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        MOD = 1000000007
        
        # Start with even_count = 1 to account for an empty prefix sum of 0
        even_count = 1
        odd_count = 0
        
        cur_sum = 0
        ans = 0
        
        for num in arr:
            cur_sum += num
            
            if cur_sum % 2 == 1:
                # Odd - Even = Odd
                ans = (ans + even_count) % MOD
                odd_count += 1
            else:
                # Even - Odd = Odd
                ans = (ans + odd_count) % MOD
                even_count += 1
                
        return ans




        
