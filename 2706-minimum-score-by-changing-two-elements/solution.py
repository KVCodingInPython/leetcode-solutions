class Solution:
    def minimizeSum(self, nums: List[int]) -> int:
        # low = min(abs(nums[i] - nums[j]))
        # high = max(abs(nums[i] - nums[j]))
        # score = high + low
    # Minimum absolute difference must be positive so must always be 0
    # Maximum absolute difference (take largest element - smallest element)  
        n = len(nums)
        nums.sort()
        return min(nums[n - 1] - nums[2], nums[n - 2] - nums[1], nums[n - 3] - nums[0])
            
