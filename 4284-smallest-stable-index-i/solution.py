class Solution(object):
    def firstStableIndex(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # if nums in strictly ascending order then return -1, since all indices equal to 0
        # Also if nums in strictly desceding order return -1
        # max(nums[0...i]) - min(nums[i...n - 1])
        # [5, 0, 1, 4] -> 5, 5, 4, 1
        # [0, 1, 4, 5] -> 0, 0, 0, 0
        # [1, 2, 3] -> 0, 0, 0
        # [3, 2, 1] -> 2, 2, 
        smallest_idx = len(nums)
        for i in range(len(nums)):
            max_val = max(nums[0:i + 1])
            min_val = min(nums[i:len(nums)])
            score = max_val - min_val
            if (score <= k and i < smallest_idx):
                smallest_idx = i

        if (smallest_idx == len(nums)): 
            return -1


        return smallest_idx
        








        return smallest_idx;

        
