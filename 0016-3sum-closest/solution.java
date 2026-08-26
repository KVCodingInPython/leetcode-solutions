class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest_sum = nums[0] + nums[1] + nums[2];
        int closest_distance = Math.abs(closest_sum - target);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int current_sum = nums[i] + nums[left] + nums[right];
                int current_distance = Math.abs(current_sum - target);
                if (current_distance < closest_distance) {
                    closest_distance = current_distance;
                    closest_sum = current_sum;
                }
                if (current_sum < target) {
                    left++;
                }
                else if (current_sum > target) {
                    right--;
                }
                else {
                    current_sum = target;
                    return current_sum;
                }
            }
        }
        return closest_sum;
    }
}
