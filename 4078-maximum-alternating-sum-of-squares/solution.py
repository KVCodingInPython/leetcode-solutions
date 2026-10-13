class Solution(object):
    def maxAlternatingSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        score = 0
        n = len(nums)

        maxHeap = []
        heapify(maxHeap)

        for num in nums:
            heappush(maxHeap, -1 * abs(num))

        for i in range(0, n, 2):
            num = heappop(maxHeap)
            score += num * num
        
        for i in range(1, n, 2):
            num = heappop(maxHeap)
            score -= num * num
        

        return score


        
        
        

        
        
