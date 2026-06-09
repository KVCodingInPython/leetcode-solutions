class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> match(2);
        for (int i = 0; i < nums.size();i++) {
            for (int j = 1; j < nums.size(); j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    match[0] = i;
                    match[1] = j;
                    return match;
                }
            }
            
            
        }
        return match;
        
    }
};
