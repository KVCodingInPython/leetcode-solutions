class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        // Find total sum of array and subtract away from x to create a 'target'
        int total_sum = 0;

        for (int i = 0; i < nums.size(); i++) {
            total_sum += nums[i];
        }

        int target = total_sum - x;

        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return nums.size();
        }

        // Implement sliding window algorithm to find target by shrinking or extending a window (Kadanes algorithm)
        int current_sum = 0;
        int left = 0;
        int min_operations = -1;
        for (int right = 0; right < nums.size(); right++) {
            current_sum += nums[right];

            while (current_sum > target && left <= right) {
                current_sum -= nums[left];
                left++;
            }

            if (current_sum == target) {
                min_operations = max(min_operations, right - left + 1);
            }
            
        }
        return min_operations == -1 ? -1 : nums.size() - min_operations;
    }
};
