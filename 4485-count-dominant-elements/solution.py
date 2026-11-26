class Solution:
    def countDominantElements(self, nums: list[int]) -> int:

        if len(nums) == 1:
            return 1

        dominant_number = 0
        for i in range(len(nums)):
            if i != 0 and i != len(nums) - 1:
                avg = (nums[i + 1] + nums[i - 1]) / 2
                if nums[i] >= avg:
                    dominant_number += 1
            
            elif i == len(nums) - 1:
                if nums[i - 1] <= nums[i]:
                    dominant_number += 1
            
            elif i == 0:
                if nums[i + 1] <= nums[i]:
                    dominant_number += 1
        
        return dominant_number
            

        
