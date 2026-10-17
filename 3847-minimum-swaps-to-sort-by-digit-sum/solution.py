class Solution(object):
    def minSwaps(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        indexed_nums = []
        for i in range(n):
            val = nums[i]
            d_sum = self.get_digit_sum(val)
            indexed_nums.append((d_sum, val, i))
        
        indexed_nums.sort(key = lambda x: (x[0], x[1]))

        target_pos = [0] * n

        for i in range(n):
            orig_idx = indexed_nums[i][2]
            target_pos[orig_idx] = i

        visited = [False] * n
        swaps = 0
        for i in range(n):
            # Already a part of another cycle Or
            # in its correct position
            #if v 
            if visited[i] or target_pos[i] == i:
                continue
            
            # Traverse the cycle
            cycle_size = 0
            curr = i
            while not visited[curr]:
                visited[curr] = True
                curr = target_pos[curr]
                cycle_size += 1
            if cycle_size > 1:
                swaps += (cycle_size - 1)
        data = swaps

        return data
    
    def get_digit_sum(self, num):
        s = 0
        while num > 0:
            s += num % 10
            num //= 10
        return s
        
