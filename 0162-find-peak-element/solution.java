class Solution {
    public int findPeakElement(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            if (nums.length == 1) {
                return 0;
            }
            if (i == 0) {
                if (nums[i] > nums[i+1]) {
                    return i;
                }
            }
            else if (i == nums.length - 1) {
                if (nums[i] > nums[i-1]) {
                    return i;
                }
                
            }
            else {
                if ((nums[i] > nums[i-1]) && (nums[i] > nums[i+1]) ) {
                    return i;
                }
            }
                
          
        }
        return -1;
            
    }
        
}
