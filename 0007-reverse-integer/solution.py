class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        isNegative = False
        ans = ""
        num = str(x)
        
        n = len(num) - 1
        if num[0] == '-':
            ans += "-"
            isNegative = True
        if isNegative == True:
            for i in range(n, 0, -1):
                ans += num[i]
        else:
            for i in range(n, -1, -1):
                ans += num[i]
        
        ans = int(ans)

        if ans < -2147483648 or ans > 2147483647:
            return 0

        return ans
