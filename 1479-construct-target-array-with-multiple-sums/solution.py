class Solution:
    def isPossible(self, target: list[int]) -> bool:
        # First find length of list target, and check if the current sum of all elements in target is the same parity as the length of target, if not, return false, else backtrack until you reach [1,1,1]: Replace the largest element in target with a number such that its sum with the other numbers in target give you the biggest element originally
        n = len(target)
        # loop through target to find initial sum and maximum in array
        # Pointer for accessing elements linearly in target

        if n == 1:
            return target[0] == 1
        
        total_sum = sum(target)

        max_heap = [-x for x in target]
        heapq.heapify(max_heap)

        while True:
            largest = -heapq.heappop(max_heap)
            rest_sum = total_sum - largest

            if largest == 1 or rest_sum == 1:
                return True
            if largest <= rest_sum or rest_sum == 0 or largest % rest_sum == 0:
                return False
            

            new_val = largest % rest_sum
            total_sum = rest_sum + new_val
            heapq.heappush(max_heap, -new_val)
        
        
        # Compare parities of target sum with the length of target array
