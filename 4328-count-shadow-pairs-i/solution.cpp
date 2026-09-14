class Solution {
public:
    long long shadowPairs(vector<int>& nums) {
        long long ans = 0;
        vector<int> s;

        for (int x : nums) {
            while (!s.empty() && s.back() > x)
                s.pop_back();

            int bound = lower_bound(s.begin(), s.end(), x) - s.begin();
            ans += bound;

            s.push_back(x);
        }

        return ans;
    }
};
