class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int[] diff = new int[n];
        long total_diff = 0;
        int max_val = 0;
        // First find maximum difference to start off with for greedy choices where k > 0, ie k1 + k2 > 0
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            total_diff += diff[i];
            max_val = Math.max(max_val, diff[i]);
        }
        // If total differences are <= k, reduce everything to 0
        if (total_diff <= k) {
            return 0;
        }

        // Use a frequency array to count occurrences of each difference

        long[] count = new long[max_val + 1];
        for (int d : diff) {
            count[d]++;
        }

        // Step 3: Greedily reduce the largest differences down using budget k
        for (int i = max_val; i > 0 && k > 0; i--) {
            if (count[i] == 0) {
                continue;
            }

            long reduce = Math.min(k, count[i]);
            count[i] -= reduce;
            count[i - 1] += reduce;
            k -= reduce;
        }

        // Step 4: Calculate the final minimum sum of squared differences
        long res = 0;
        for (int i = 0; i <= max_val; i++) {
            if (count[i] > 0) {
                res += count[i] * (long) i * i;
            }

        }
        return res;
    }
}
