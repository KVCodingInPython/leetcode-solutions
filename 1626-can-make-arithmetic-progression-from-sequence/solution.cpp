class Solution {
public:
    bool canMakeArithmeticProgression(vector<int>& arr) {
        // S_n = n/2(a + l)
        // Lets assume a is minimum of array and l is maximum of array
        // if (2S_n / (a + l)) == n (arr.size()), then return true
        sort(arr.begin(), arr.end());
        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.size(); i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
};
