class Solution {
public:
    bool uniformArray(vector<int>& nums1) {
    int even_count = 0;
    int odd_count = 0;
    int min = INT_MAX;
    for (int i = 0; i < nums1.size(); i++) {
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

    if (even_count == nums1.size() || odd_count == nums1.size()) {
        return true;
    }

    return (min % 2 != 0);
    
    }  
};
