class Solution {
public:
    int minKBitFlips(vector<int>& nums, int k) {
        int count_flips = 0;
        int currently_active_flips = 0;
        int n = nums.size();
        
        for (int i = 0; i < n; i++) {
             // Check in window of length k, if there any currently active flips that may expire so within 'i -k' range
            if (i >= k && nums[i - k] == 2) {
                currently_active_flips--;
            }

            if (nums[i] == (currently_active_flips % 2)) {
                if (i + k > n) {
                    return -1;
                }
                count_flips += 1;
                currently_active_flips += 1;
                nums[i] = 2;
            }

        }
        return count_flips;
       
    }
};
