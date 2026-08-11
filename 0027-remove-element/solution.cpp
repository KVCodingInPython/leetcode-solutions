#include <iostream>
#include <string>
#include <vector>

using std::cout;
using std::endl;
using std::cin;

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.at(i) == val) {
                count = count + 1;
            }
        }

        int k = nums.size() - count;
        auto ne = remove(nums.begin(), nums.end(), val);
        nums.erase(ne, nums.end());
        
        return k;


        
    }
};
