class Solution {
    public int missingMultiple(int[] nums, int k) {
        // Since nums[i] <= 100, we create a boolean array up to index 100

        boolean[] present = new boolean[101];
        for (int num : nums) {
            present[num] = true;
        }

        // Check multiples of k: k, 2k, 3k...
        for (int i = 1; ; i++) {
            int currentMultiple = k * i;
            
            // If the multiple goes beyond 100, it's guaranteed to be missing
            // Or if it's <= 100 but marked false, we found our answer
            if (currentMultiple > 100 || !present[currentMultiple]) {
                return currentMultiple;
            }
        }
    }
}
