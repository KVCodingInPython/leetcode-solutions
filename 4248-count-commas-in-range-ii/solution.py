class Solution(object):
    def countCommas(self, n):
        """
        :type n: int
        :rtype: int
        """

        # return type: int; n: int

        comma_count = 0;
        commas = 1;
        base = 1000;

        while n >= base:
            if n > (base * 1000) - 1:
                comma_count += ((base * 1000) - base) * commas
            
            else:
                comma_count += ((n - base) + 1) * commas
            
            commas += 1
            base *= 1000
        return comma_count
        

            

        
        
