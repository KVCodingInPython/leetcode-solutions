class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_sum = nums[0]
        if len(nums) == 1:
            return nums[0]
        n = len(nums)
        cur_sum = 0
        right = 0
        while right < n:
                cur_sum += nums[right]
                max_sum = max(cur_sum, max_sum)
                if cur_sum < 0:
                    cur_sum = 0
                right += 1


        return max_sum

         
        


        
