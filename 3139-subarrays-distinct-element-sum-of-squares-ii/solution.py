class Solution(object):
    def sumCounts(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # [1,2,1] -> [1], [1, 2], [1,2,1] -> [2], [2, 1](1)^2 + (2)^2 + (2)# ^2 = 9
        MOD = 10**9 + 7
        n = len(nums)

        # Segment tree arrays
        tree_sum2 = [0] * (4 * n)  # sum of squares
        tree_sum1 = [0] * (4 * n)  # sum of values
        lazy = [0] * (4 * n)

        def push(node, l, r):
            if lazy[node] != 0:
                v = lazy[node]
                mid = (l + r) // 2

                # Left Child Update
                left = 2 * node + 1
                tree_sum2[left] = (tree_sum2[left] + 2 * v * tree_sum1[left] + v * v * (mid - l + 1)) % MOD
                tree_sum1[left] = (tree_sum1[left] + v * (mid - l + 1)) % MOD
                lazy[left] = (lazy[left] + v) % MOD

                # Right Child Update
                right = 2 * node + 2
                tree_sum2[right] = (tree_sum2[right] + 2 * v * tree_sum1[right] + v * v * (r - mid)) % MOD
                tree_sum1[right] = (tree_sum1[right] + v * (r - mid)) % MOD
                lazy[right] = (lazy[right] + v) % MOD

                lazy[node] = 0
            return
        def update(node, l, r, ql, qr, v):
            if ql <= l and r <= qr:
                tree_sum2[node] = (tree_sum2[node] + 2 * v * tree_sum1[node] + v * v * (r - l + 1)) % MOD
                tree_sum1[node] = (tree_sum1[node] + v * (r - l + 1)) % MOD
                lazy[node] = (lazy[node] + v) % MOD
                return
            
            push(node, l, r)
            mid = (l + r) // 2
            if ql <= mid:
                update(2 * node + 1, l, mid, ql, qr, v)
            if qr > mid:
                update(2 * node + 2, mid + 1, r, ql, qr, v)
            
            tree_sum1[node] = (tree_sum1[2 * node + 1] + tree_sum1[2 * node + 2]) % MOD
            tree_sum2[node] = (tree_sum2[2 * node + 1] + tree_sum2[2 * node + 2]) % MOD

        last_seen = {}
        total_sum = 0

        for r in range(n):
            l = last_seen.get(nums[r], -1) + 1
            update(0, 0, n - 1, l, r, 1)
            last_seen[nums[r]] = r
            
            total_sum = (total_sum + tree_sum2[0]) % MOD

        return total_sum


        
               
        
