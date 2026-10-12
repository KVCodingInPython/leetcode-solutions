class Solution(object):
    def maxSum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        MOD = 10**9 + 7
       
        # Step 1: Count how many numbers have each bit set (up to 31 bits)
        bit_count = [0] * 31
        for num in nums:
            for i in range(31):
                if (num >> i) & 1:
                    bit_count[i] += 1
        
        total_sum = 0
        for _ in range(k):
            curr_num = 0
            for i in range(31):
                if bit_count[i] > 0:
                    curr_num |= (1 << i)
                    bit_count[i] -= 1

            # Step 3: Add square of the constructed number to total sum
            total_sum = (total_sum + curr_num * curr_num) % MOD

        return total_sum


        

        
        


        
