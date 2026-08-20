class Solution {
public:
    vector<int> resultArray(vector<int>& nums) {
        std::vector<int> arr1;
        std::vector<int> arr2;
        std::vector<int> result;

        arr1.push_back(nums[0]);
        arr2.push_back(nums[1]);

        for (int i = 3; i <= nums.size(); i++) {
            if (arr1.back() > arr2.back()) {
                arr1.push_back(nums[i-1]);
            }
            else {
            arr2.push_back(nums[i-1]);
            }
        }

        for (int i = 0; i < arr1.size(); i++) {
            result.push_back(arr1[i]);
        }

        for (int i = 0; i < arr2.size(); i++) {
            result.push_back(arr2[i]);
        }

        return result;


        
    }
};
