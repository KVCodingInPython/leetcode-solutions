class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        // 1. Case 0: No element removed
        int maxSplits = countSplitsForArray(nums);

        // 2. Case 1: Try removing every index k
        for (int k = 0; k < n; k++) {
            // Build temporary array without nums[k]
            int[] temp = new int[n - 1];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (i != k) {
                    temp[idx++] = nums[i];
                }
            }
            maxSplits = Math.max(maxSplits, countSplitsForArray(temp));
        }

        return maxSplits;
    }

    // Helper method: standard O(N) prefix-suffix GCD split counter
    private int countSplitsForArray(int[] arr) {
        int m = arr.length;
        if (m <= 1) return 0;

        int[] suff = new int[m];
        suff[m - 1] = arr[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            suff[i] = gcd(suff[i + 1], arr[i]);
        }

        int count = 0;
        int pref = 0;
        for (int i = 0; i < m - 1; i++) {
            pref = gcd(pref, arr[i]);
            if (pref == suff[i + 1]) {
                count++;
            }
        }
        return count;
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

