class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] missingData = new int[2];
        HashSet<Integer> duplicateNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (duplicateNums.contains(nums[i])) {
                missingData[0] = nums[i];
            }
            else {
                duplicateNums.add(nums[i]);
            }
        }
        int i = 1;
        while (i <= nums.length) {
            if (!duplicateNums.contains(i)) {
                missingData[1] = i;
                break;
            }
            i++;
        }
        return missingData;
        
    }
}
