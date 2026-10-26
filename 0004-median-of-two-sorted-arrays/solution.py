class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        m = len(nums1)
        n = len(nums2)
        res = [0] * (m + n)
        i = 0
        j = 0
        k = 0
        while i < m and j < n:
            if nums1[i] < nums2[j]:
                res[k] = nums1[i]
                i += 1
                k += 1
            else:
                res[k] = nums2[j]
                j += 1
                k += 1

        while i < m:
            res[k] = nums1[i]
            i += 1
            k += 1

        while j < n:
            res[k] = nums2[j]
            j += 1
            k += 1
        
        print(res)

        if len(res) % 2 == 0:
            median = float((res[len(res) // 2] + res[(len(res) // 2) - 1])) / 2
            return median
        median = res[len(res) // 2]
        return median
        

        # [1,2,3,4,5,6,7,8] = [4,5] which is 3rd and 4th index of length 8 array 
        # Therefore median of even-length array, where len(arr) % 2 == 0, is given generally as median = (len(arr) // 2 + (len(arr) // 2) - 1) / 2
        # If array is of odd length then median = len(arr) // 2
