class Solution(object):
    def minOperations(self, nums, x):
        """
        :type nums: List[int]
        :type x: int
        :rtype: int
        """
        total_sum = sum(nums)
        target = total_sum - x

        # Edge cases
        if target < 0:
            return -1
        if target == 0:
            return len(nums)

        left = 0
        current_window = 0
        max_len = -1  # Default to -1 so we know if a valid window was found

        for right in range(len(nums)):
            current_window += nums[right]

            # Phase 2: Shrink window while it exceeds the target remainder
            while current_window > target and left <= right:
                current_window -= nums[left]
                left += 1

            # Phase 3: Check if we matched the target remainder
            if current_window == target:
                max_len = max(max_len, right - left + 1)

        # Total elements minus longest middle subarray length
        return len(nums) - max_len if max_len != -1 else -1

        
