class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        int digit_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            digit_sum = computeDigitSum(nums[i]);
            if (digit_sum == i) {
                return i;
            }
        }
        return -1;
    }

    public int computeDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num = (int) (num / 10);
        }
        return sum;
    }
}
