class Solution(object):
    def findTheDistanceValue(self, arr1, arr2, d):
        """
        :type arr1: List[int]
        :type arr2: List[int]
        :type d: int
        :rtype: int
        """
        arr1_length = len(arr1)
        arr2_length = len(arr2)
        element_count = arr1_length
        for i in range(arr1_length):
            for j in range(arr2_length):
                
                if abs(arr1[i] - arr2[j]) <= d:
                    element_count -= 1
                    break
                    
        return element_count
        
