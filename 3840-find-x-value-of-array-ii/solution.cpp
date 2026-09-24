#include <vector>
#include <array>

class Solution {
public:
    struct Node {
        int prod = 1;
        std::array<int, 5> pref{}; // Value-initialized to 0
    };

    int k;

    std::vector<int> resultArray(std::vector<int>& nums, int k_val, std::vector<std::vector<int>>& queries) {
        int n = nums.size();
        this->k = k_val;

        for (int i = 0; i < n; i++) {
            nums[i] %= k;
        }

        std::vector<Node> tree(4 * n);
        build(1, 0, n - 1, nums, tree);

        std::vector<int> ans(queries.size());

        for (int q = 0; q < queries.size(); q++) {
            int idx = queries[q][0];
            int val = queries[q][1] % k; // Ensure value is modulo k
            int start = queries[q][2];
            int x = queries[q][3];

            update(1, 0, n - 1, idx, val, tree);

            Node res = query(1, 0, n - 1, start, n - 1, tree);

            ans[q] = res.pref[x];
        }
        return ans;
    }

    void build(int node, int start, int end, const std::vector<int>& nums, std::vector<Node>& tree) {
        if (start == end) {
            setLeaf(tree[node], nums[start]);
            return;
        }

        int mid = start + (end - start) / 2;

        build(2 * node, start, mid, nums, tree);
        build(2 * node + 1, mid + 1, end, nums, tree);
        mergeNode(tree[node], tree[2 * node], tree[2 * node + 1]);
    }    

    void setLeaf(Node& cur, int val) {
        cur.pref.fill(0);
        cur.pref[val] = 1;
        cur.prod = val % k;
    }

    void update(int node, int start, int end, int idx, int val, std::vector<Node>& tree) {
        if (start == end) {
            setLeaf(tree[node], val);
            return;
        }
        int mid = start + (end - start) / 2;
        
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val, tree);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val, tree);
        }
        mergeNode(tree[node], tree[2 * node], tree[2 * node + 1]);
    }

    Node query(int node, int start, int end, int l, int r, std::vector<Node>& tree) {
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;

        if (r <= mid) {
            return query(2 * node, start, mid, l, r, tree);
        }
        if (l > mid) {
            return query(2 * node + 1, mid + 1, end, l, r, tree);
        }

        Node leftRes = query(2 * node, start, mid, l, r, tree);
        Node rightRes = query(2 * node + 1, mid + 1, end, l, r, tree);
        
        Node combined;
        mergeNode(combined, leftRes, rightRes);
        return combined;
    }

    void mergeNode(Node& res, const Node& L, const Node& R) {
        res.pref.fill(0);
        res.prod = (L.prod * R.prod) % k;

        for (int i = 0; i < k; i++) {
            res.pref[i] += L.pref[i];
        }

        for (int i = 0; i < k; i++) {
            int rem = (L.prod * i) % k;
            res.pref[rem] += R.pref[i];
        }
    }
};
