class Solution {
    public int minimumDeletions(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxIdx = 0;
        int minIdx = 0;
        int n = nums.length;
       
        int halfLength = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
            else if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
        }
        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);

        // Option 1 : Remove both from front
        int frontOnly = right + 1;

        // Option 2: Remove both from back
        int backOnly = n - left;

        // Option 3: Remove one from the front, and the other from the back
        int frontAndBack = (left + 1) + (n - right);

        return Math.min(frontOnly, Math.min(backOnly, frontAndBack));
    }
}
