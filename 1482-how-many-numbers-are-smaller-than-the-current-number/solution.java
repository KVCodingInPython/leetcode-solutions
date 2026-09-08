class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int count = 0;
        int[] smallerNums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i] && j != i) {
                    count += 1;
                }
                smallerNums[i] = count;
            }
            count = 0;
        }
        return smallerNums;
    }
}
