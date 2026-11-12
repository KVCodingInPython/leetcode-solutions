class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        
        increment_count = 1
        decrement_count = 1
        ans = 1
        for right in range(len(nums) - 1):
            if nums[right] < nums[right + 1]:
                increment_count += 1
                decrement_count = 1

            elif nums[right] > nums[right + 1]:
                decrement_count += 1
                increment_count = 1

            else:
                increment_count = 1
                decrement_count = 1

            ans = max(increment_count, decrement_count, ans)
    
    
        return ans




        
