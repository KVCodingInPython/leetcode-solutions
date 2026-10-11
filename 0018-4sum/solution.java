class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // Base Case: we need at least length 4, since we need distinct indices a,b,c,d such that 0 <= a,b,c,d < n
        if (n < 4) {
            return res;
        }
        Arrays.sort(nums);

        for (int a = 0; a < n; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < n; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                int left = b + 1;
                int right = n - 1;
                while (left < right) {
                      long total = (long) nums[a] + nums[b] + nums[left] + nums[right]; 
                      if (total == target) {
                        res.add(Arrays.asList(nums[a], nums[b], nums[left], nums[right]));
                        // Skip duplicates for the third and fourth numbers
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                      }
                      else if (total < target) {
                        left++;
                      }
                      else {
                        right--;
                      }

                }
            }
        }
        return res;
    }
}
