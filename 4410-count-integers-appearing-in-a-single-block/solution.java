

class Solution {
    public int countSpecialIntegers(int[] nums) {
        // Assuming values in nums are bounded between 0 and 1000
        int MAX_VAL = 1000;
        
        int[] firstIdx = new int[MAX_VAL + 1];
        int[] lastIdx  = new int[MAX_VAL + 1];
        int[] freq     = new int[MAX_VAL + 1];

        // Initialize firstIdx array with -1 to track unvisited numbers
        Arrays.fill(firstIdx, -1);

        // Single pass to record first index, last index, and total occurrences
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            
            if (firstIdx[val] == -1) {
                firstIdx[val] = i; // First time seeing this number
            }
            lastIdx[val] = i;      // Continually updates to latest index
            freq[val]++;           // Increment occurrence count
        }

        int specialCount = 0;

        // Check single-block condition for every number that appeared
        for (int val = 0; val <= MAX_VAL; val++) {
            if (freq[val] > 0) {
                // Number appears in a single block if span equals its frequency
                if (lastIdx[val] - firstIdx[val] + 1 == freq[val]) {
                    specialCount++;
                }
            }
        }

        return specialCount;
    }
}
