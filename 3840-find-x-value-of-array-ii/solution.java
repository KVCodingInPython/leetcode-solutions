import java.util.Arrays;

class Solution {
    static class Node {
        int[] pref = new int[5]; // Count of valid prefixes starting at node's left boundary
        int prod = 1;            // Product modulo k of all elements in this node's range
    }

    private int k;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            nums[i] %= k;
        }

        Node[] tree = new Node[4 * n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }

        build(1, 0, n - 1, nums, tree);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int idx = queries[q][0];
            int val = queries[q][1] % k;
            int start = queries[q][2];
            int targetX = queries[q][3];

            update(1, 0, n - 1, idx, val, tree);

            Node res = query(1, 0, n - 1, start, n - 1, tree);

            ans[q] = res.pref[targetX];
        }

        return ans;
    }

    private void build(int node, int start, int end, int[] nums, Node[] tree) {
        if (start == end) {
            setLeaf(tree[node], nums[start]);
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid, nums, tree);
        build(2 * node + 1, mid + 1, end, nums, tree);
        mergeNode(tree[node], tree[2 * node], tree[2 * node + 1]);
    }

    private void setLeaf(Node cur, int val) {
        Arrays.fill(cur.pref, 0);
        cur.pref[val] = 1;
        cur.prod = val;
    }

    private void update(int node, int start, int end, int idx, int val, Node[] tree) {
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

    private Node query(int node, int start, int end, int l, int r, Node[] tree) {
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

        Node combined = new Node();
        mergeNode(combined, leftRes, rightRes);
        return combined;
    }

    private void mergeNode(Node res, Node L, Node R) {
        Arrays.fill(res.pref, 0);

        res.prod = (L.prod * R.prod) % k;

        for (int i = 0; i < k; i++) {
            res.pref[i] += L.pref[i];
        }

        for (int i = 0; i < k; i++) {
            int rem = (L.prod * i) % k;
            res.pref[rem] += R.pref[i];
        }
    }
}
