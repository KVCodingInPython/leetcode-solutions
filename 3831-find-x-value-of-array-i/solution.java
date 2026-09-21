class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];
        for (int i = 0; i < nums.length; i++) {
            long[] nextDp = new long[k];
            // Compute remainder for each element of nums, and increment dp index = rem
            int rem = nums[i] % k;
            nextDp[rem]++;
            // Extend subarray to previous remainders computed earlier on
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newRem = (r * rem) % k;
                    nextDp[newRem] += dp[r];
                }

            }

            // 3. Accumulate current index counts int overall result
            for (int r = 0; r < k; r++) {
                result[r] += nextDp[r];
            }

            // 4. Move to next position
            dp = nextDp;
        }
        return result;
    }
}
