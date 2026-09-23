class Solution {
    public int minOperations(int[] nums, int x) {
        // target = 6
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        int target = totalSum - x;

        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return nums.length;
        }
        int right = 0;
        int currentSum = 0;
        int minOperations = -1;
        for (int left = 0; left < nums.length; left++) {
            currentSum += nums[left];

            while (currentSum > target && right <= left) {
                currentSum -= nums[right];
                right++;
            }
            if (currentSum == target) {
                minOperations = Math.max(minOperations, left - right + 1);
            }
        }
        return minOperations == - 1 ? -1 : nums.length - minOperations;
    }
}
