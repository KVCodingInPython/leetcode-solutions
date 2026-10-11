class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0;
        int n = nums.length;
        int[] res = {-1, -1};
        if (nums == null || n == 0) {
            return res;
        }

        res[0] = findBound(nums, n, target, true);
        res[1] = findBound(nums, n, target, false);
      
        return res;
        
    }
    public int findBound(int[] nums, int length, int target, boolean isFirst) {
        int lo = 0;
        int hi = length - 1;
        int bound = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            }
            else if (nums[mid] > target) {
                hi = mid - 1;
            }
            else if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }

            }
        }
        return bound;
    }
}
