class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffledNums = new int[2 * n];
        // Even indices for x-coordinates
        for (int i = 0; i < n; i++) {
            shuffledNums[2 * i] = nums[i];
            shuffledNums[2 * i + 1] = nums[n + i];
        }
        return shuffledNums;
    }
}
