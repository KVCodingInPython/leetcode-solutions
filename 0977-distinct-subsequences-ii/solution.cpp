class Solution {
public:
    int distinctSubseqII(string s) {

    // DP Problem
    // 'dp[i][j]', where 'i' represents the 'ith' char in 's', and 'j' represents the subsequences of 's', sizeof j = s.length()**2

    // Base Case - s.length() == 1: exactly 1 subsequence
    // Use bit masking / all distinct sets of bits for given 'n', will produce all distinct subsequences
        // 0001 && 0000 -> 00000 - false
        // 0010 && 0000 -> 00000 - false
        long long MOD = 1e9 + 7;
        int n = s.length();
        
        // dp[i] stores the number of distinct subsequences using the first i characters
        vector<long long> dp(n + 1, 0);
        dp[0] = 1; // Base case: empty subsequence
        
        // Last seen position for each character ('a' through 'z')
        vector<int> last(26, -1);
        
        for (int i = 0; i < n; i++) {
            int x = s[i] - 'a';
            
            // Double the previous total count
            dp[i + 1] = (2 * dp[i]) % MOD;
            
            // If character was seen before, subtract the duplicates
            if (last[x] != -1) {
                dp[i + 1] = (dp[i + 1] - dp[last[x]] + MOD) % MOD;
            }
            
            // Update the last occurrence of the current character
            last[x] = i;
        }
        
        // Subtract 1 to exclude the empty subsequence
        return (dp[n] - 1 + MOD) % MOD;
    }
};
