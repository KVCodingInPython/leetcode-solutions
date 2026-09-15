class Solution {
public:
    int maxPalindromes(string s, int k) {
        int palindrome_count = 0;
        int n = s.length();
        vector<int> dp(n + 1, 0);

        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i];

            // Option B: Check if s[i] can end a valid palindrome of length k or k+1
            // (We only check length k and k+1 because smaller = better for greedy/DP)
            if (i - k + 1 >= 0 && isPalindrome(s, i - k + 1, i)) {
                dp[i + 1] = max(dp[i + 1], 1 + dp[i - k + 1]);
            }
            if (i - k >= 0 && isPalindrome(s, i - k, i)) {
                dp[i + 1] = max(dp[i + 1], 1 + dp[i - k]);
            }
        }
        return dp[n];
    }

    bool isPalindrome(const string& s, int left, int right) {
        while (left < right) {
            if (s.at(left++) != s.at(right--)) {
                return false;
            }
        }
        return true;
    }
};
