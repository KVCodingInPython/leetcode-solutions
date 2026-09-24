class Solution:
    def smallestIndex(self, nums: List[int]) -> int:
        n = len(nums)
        for i in range(n):
            digit_sum = self.computeDigitSum(nums[i])
            if digit_sum == i:
                return i
        return -1


    def computeDigitSum(self, num: int) -> int:
        sum = 0
        while num > 0:
            sum += (num % 10)
            num //= 10
        return sum
            
        
