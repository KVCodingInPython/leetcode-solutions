class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suff_min = new int[n];
        suff_min[n-1] = nums[n-1];
        for (int i = n - 2; i >= 0; i--) {
            suff_min[i] = Math.min(nums[i], suff_min[i+1]);
        }

        int pref_max = nums[0];

        for (int i = 0; i < n; i++) {
            pref_max = Math.max(pref_max, nums[i]);
            int score = pref_max - suff_min[i];

            if (score <= k) {
                return i;
            }
        }

        return -1;
    }
}
