class Solution(object):
    def minOperations(self, s):
        """
        :type s: str
        :rtype: int
        """
        # count = 0
        length = len(s)
        # Base Case, if already sorted in order
        if all(a <= b for a,b in zip(s, s[1:])):
            return 0

        # If length is 2, and out of order impossible
        # Since we cannot take a substring thats not entire string, then for length 2 substrings of only 1 yet we cannot compare, we want to compare pairs of letters in strings, and so if and only if letters are in correct alphabetical order, then return 0, else -1
        if len(s) == 2:
            return -1
        
        mn, mx = min(s), max(s)

        if s[0] == mn or s[-1] == mx:
            return 1
        
        if any(c in (mn, mx) for c in s[1:-1]):
            return 2
        
        return 3
            


        # For each letter check all letters after that and check whether ascii val is less than it, increment val at that index (index of orig element checking)
        '''suffix_arr = [0] * length

        for i in range(length - 1):
            for j in range(i + 1, length):
                if ord(s[i]) > ord(s[j]):
                    suffix_arr[i] += 1
        print(suffix_arr)
        # Find max_val of suffix_array
        max_val = suffix_arr[0]
        for i in range(1, length):
            if suffix_arr[i] > max_val:
                max_val = suffix_arr[i]
        
        return max_val
        '''
            


            
            
        # return count



        
        '''# Step case, length >= 2
        letter_ascii_values = [0] * length

        for i in range(length):
            val = ord(s[i])
            letter_ascii_values[i] = val
        

        print(letter_ascii_values)

        # Find min number of swaps to swap nums in array such that ascending order
        '''
            

        


        
