class UnionFind {
    private int[] parent;
    private int[] rank;
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false;
        }

        if (rank[rootX] > rank[rootY]) {
            parent[rootX] = rootY;
        }
        else if (rank[rootY] > rank[rootX]) {
            parent[rootY] = rootX;
        }
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        // Step 1: Pair numbers with original indices and sort by value
        int [][] paired = new int[n][2];
        for (int i = 0; i < n; ++i) {
            paired[i] = new int[]{nums[i], i};
        }
        Arrays.sort(paired, (a,b) -> Integer.compare(a[0], b[0]));

        // Step 2: Union adjacent pairs in sorted order if difference <= limit
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            int currentVal = paired[i][0];
            int nextVal = paired[i + 1][0];

            if (nextVal - currentVal <= limit) {
                // Connect their original indices
                uf.union(paired[i][1], paired[i + 1][1]);
            }
        }

        // Step 3: Group elements by their component root parent
        // Key: Root Parent Index -> Queue of sorted values belonging to this component
        Map<Integer, Queue<Integer>> groupValues = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = paired[i][0];
            int originalIdx = paired[i][1];
            int root = uf.find(originalIdx);

            groupValues.putIfAbsent(root, new LinkedList<>());
            groupValues.get(root).add(val); // Added in sorted order because paired is sorted
        }

        // Step 4: Reconstruct final result array
        int[] result = new int[n];
        for (int originalIdx = 0; originalIdx < n; originalIdx++) {
            int root = uf.find(originalIdx);
            // Poll the smallest remaining value for this component
            result[originalIdx] = groupValues.get(root).poll();

        }
        return result;
    }
}
