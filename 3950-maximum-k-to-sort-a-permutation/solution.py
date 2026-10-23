class Solution(object):
    def sortPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Start with k = 0
        ''' k = 0
        i = 0
        j = 0
        max_val = 0
        max_val = max(nums)
        num_indexes = []
        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1]:
                num_indexes.append(i)
        
        if max_val != nums[len(nums) - 1]:
            num_indexes.append(len(nums) - 1)
            
        if len(num_indexes) == len(nums):
            return 0

        print(num_indexes)
                
            
        for i in range(len(num_indexes) - 1):
            operation = num_indexes[i] & num_indexes[i + 1]
            if operation == k:
                max_val = max(max_val, k)
        return max_val
        '''
        ans = -1
        for i, x in enumerate(nums):
            if i != x:
                ans &= x
        
        return max(ans, 0)

        
