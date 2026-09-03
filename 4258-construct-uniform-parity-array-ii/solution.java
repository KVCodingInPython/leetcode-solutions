class Solution {
    public boolean uniformArray(int[] nums1) {
    int even_count = 0;
    int odd_count = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < nums1.length; i++) {
        if (nums1[i] < min) {
            min = nums1[i];
        }
        if (nums1[i] % 2 == 0) {
            even_count += 1;
        }
        else {
            odd_count += 1;
        }

    }

    if (even_count == nums1.length || odd_count == nums1.length) {
        return true;
    }

    return (min % 2 != 0);
    
    }  
};
    
