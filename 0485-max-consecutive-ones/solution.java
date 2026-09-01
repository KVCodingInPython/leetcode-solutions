class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // [1, 1, 0, 1, 1, 1] -> left = 0; right = 1; 
        int countOnes = 0;
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                countOnes += 1;
            }
            if (nums[i] != 1 || i == nums.length - 1) {
                if (countOnes > max) {
                    max = countOnes;
                }
                countOnes = 0;

            }
        }
        return max;
        
    }
}
