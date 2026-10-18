import math
class Solution(object):
    def numOfWays(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        MOD = 10**9 + 7

        def helper(arr):
            if len(arr) <= 2:
                return 1
            
            root = arr[0]
            left = [x for x in arr[1:] if x < root]
            right = [x for x in arr[1:] if x > root]
            
            ways_left = helper(left)
            ways_right = helper(right)

            n = len(left) + len(right)
            k = len(left)
            comb = math.factorial(n) // (math.factorial(k) * math.factorial(n - k))
            return (comb * ways_left * ways_right) % MOD

        return (helper(nums) - 1 + MOD) % MOD




