class Solution(object):
    def sumCounts(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # [1,2,1] -> [1], [1, 2], [1,2,1] -> [2], [2, 1](1)^2 + (2)^2 + (2)^2 = 9
        n = len(nums)
        total_count = 0
        # sub_array = [1,2,1]; [2,1] ; [1]
        # [1,2,1] -> [1] -> [1,2] -> [1,2,1] -> [2,1]
        for i in range(n):
            s = set()
            for j in range(i, n):
                
                s.add(nums[j])
                d = len(s)
                total_count += d * d
        
        return total_count
                

           
            
        
                


        

        
