import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        
        // Step 1: Mark visited numbers by negating values at index (val - 1)
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            int index = val - 1;
            
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        // Step 2: Collect all indices that remain positive
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
}
