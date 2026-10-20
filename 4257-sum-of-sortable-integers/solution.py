class Solution(object):
    def sortableIntegers(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        
        # Precompute prefix maximums and suffix minimums to check global sorted order between blocks
        pref_max = [0] * (n + 1)
        for i in range(n):
            pref_max[i + 1] = max(pref_max[i], nums[i])
            
        suff_min = [float('inf')] * (n + 1)
        for i in range(n - 1, -1, -1):
            suff_min[i] = min(nums[i], suff_min[i + 1])
            
        # Count internal drops (nums[i-1] > nums[i]) to check rotations in O(1)
        pref_drop = [0] * n
        for i in range(1, n):
            pref_drop[i] = pref_drop[i - 1] + (1 if nums[i - 1] > nums[i] else 0)

        def is_sortable(k):
            # Check inter-block ordering: max of block m <= min of block m+1
            for i in range(k, n, k):
                if pref_max[i] > suff_min[i]:
                    return False

            # Check intra-block rotation validity
            for i in range(0, n, k):
                l, r = i, i + k - 1
                # Number of drops strictly inside the block
                drops = pref_drop[r] - pref_drop[l] if r > l else 0
                
                if drops > 1:
                    return False
                if drops == 1:
                    # If there is a drop, it must wrap around cleanly (last element <= first element)
                    if nums[r] > nums[l]:
                        return False
                        
            return True

        sortable_sum = 0
        for k in range(1, n + 1):
            if n % k == 0:
                if is_sortable(k):
                    sortable_sum += k
                    
        return sortable_sum

        
