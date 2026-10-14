class Solution(object):
    def maxSumOfSquares(self, num, sum_):
        """
        :type num: int
        :type sum: int
        :rtype: str
        """

        # First find all good integers with digits same as num, ie if num =2, #digits = 2, and sum of digits in n is exactly equal to sum
        # Only check the numbers from 10^N-1 to 10^N-2, where N represents 'num', inclusively
        #Whilst checking these numbers have if stattements checking for the sum of digits in each number if exactly sum, then compute its score and find its max score, using max function with previous score, also store the number (n) that produced this max score in another variable
        #Keep doing this until you reach end of loop, then cast that variable storing n, to a string and return this
        # lower_bound = 10**(num - 1)
        # upper_bound = 10**(num)
        digit_str = ""
        while len(digit_str) != num:
            digit_placed = False
            for i in range(9, -1, -1):
                remaining_sum = sum_ - i
                remaining_digits = num - len(digit_str) - 1
                if remaining_sum < 0:
                    continue
                if remaining_sum > 9 * remaining_digits:
                    continue

                sum_ -= i
                digit_str += str(i)
                digit_placed = True
                break
            
            if not digit_placed:
                return ""
        if sum_ == 0:
            return digit_str
        
        return ""
  

        
