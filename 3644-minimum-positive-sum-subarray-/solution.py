class Solution(object):
    def minimumSumSubarray(self, nums, l, r):
        """
        :type nums: List[int]
        :type l: int
        :type r: int
        :rtype: int
        """
        n = len(nums)
        min_sum = float('inf')
        POSITIVE = True
        for i in range(n):
            if nums[i] < 0:
                POSITIVE = False
        
        if POSITIVE == True:
            # Just pick subarrays of size (l), smallest size possible to get min sum
            cur_sum = sum(nums[:l])
            
            if cur_sum > 0:
                min_sum = min(cur_sum, min_sum)

            i = l
            while i < n:
                cur_sum += nums[i]
                cur_sum -= nums[i - l]

                if cur_sum > 0:
                    min_sum = min(cur_sum, min_sum)
                    

                i += 1
        
        else:
            i = l
            while i <= r:
                cur_sum = sum(nums[:i])
                if cur_sum > 0:
                    min_sum = min(cur_sum, min_sum)

                j = i

                while j < n:
                    cur_sum += nums[j]
                    cur_sum -= nums[j - i]
   
                    if cur_sum > 0:
                        min_sum = min(cur_sum, min_sum)

                    j += 1

                i += 1
        

        if min_sum == float('inf'):
            return -1
        
        return min_sum
            

                

                    

              

            
        
