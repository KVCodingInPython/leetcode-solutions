class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // 2D grid: rows for s, columns for t
        long[][] dp = new long[m + 1][n + 1];
        
        // Base case: Empty t can always be formed (1 way)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the matrix row by row
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Check if characters match (remember 0-indexed strings)
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // Way 1: Match characters + Way 2: Skip s[i-1]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // Characters don't match, skip s[i-1]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        // The bottom-right cell holds the final answer
        return (int) dp[m][n];
    }
}

