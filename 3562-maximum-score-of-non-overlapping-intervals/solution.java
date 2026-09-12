class Solution {
    static class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }

        State takeInterval(int originalId, int weight) {
            List<Integer> newIndices = new ArrayList<>(this.indices);
            // Insert id while keeping the list sorted for easy lexicographical comparison
            int pos = 0;
            while (pos < newIndices.size() && newIndices.get(pos) < originalId) {
                pos++;
            }
            newIndices.add(pos, originalId);
            
            return new State(this.score + weight, newIndices);
        }
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] sortedIntervals = new int[n][4];

        for (int i = 0; i < n; i++) {
            sortedIntervals[i][0] = intervals.get(i).get(0); // l
            sortedIntervals[i][1] = intervals.get(i).get(1); // r
            sortedIntervals[i][2] = intervals.get(i).get(2); // w
            sortedIntervals[i][3] = i;
        }

        // Sort by start time: 'l'
        Arrays.sort(sortedIntervals, (a,b) -> Integer.compare(a[0], b[0]));

        // 2. Precompute next valid non-overlapping interval for each index using Binary Search
        int[] nextValid = new int[n];
        for (int i = 0; i < n; i++) {
            nextValid[i] = findNextValid(sortedIntervals, sortedIntervals[i][1]);
        }


        State[][] dp = new State[n+1][5];
        // Base cases: Empty choices at end boundary n
        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new ArrayList<>());
        }
        // 4. Bottom-Up Iteration (Right to Left)
        for (int i = n - 1; i >= 0; i--) {
            // k = 0 base case: taking 0 intervals gives score 0
            dp[i][0] = new State(0, new ArrayList<>());

            for (int k = 1; k <= 4; k++) {
                // Option 1: Skip interval i
                State skip = dp[i + 1][k];

                // Option 2: Take interval i
                int next = nextValid[i];
                State take = dp[next][k - 1].takeInterval(sortedIntervals[i][3], sortedIntervals[i][2]);

                // Choose the optimal state
                dp[i][k] = getBetterState(skip, take);
            }
        }
        // Extract result array from optimal DP state
        List<Integer> bestIndices = dp[0][4].indices;
        int[] ans = new int[bestIndices.size()];
        for (int i = 0; i < bestIndices.size(); i++) {
            ans[i] = bestIndices.get(i);
        }

        return ans;
    }
    // Finds the first interval whose start time l is STRICTLY GREATER than target (r_i)
    private int findNextValid(int[][] sortedIntervals, int target) {
        int low = 0;
        int high = sortedIntervals.length;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (sortedIntervals[mid][0] > target) {
                high = mid; // Candidate found, look left for an earlier valid index
            } else {
                low = mid + 1; // Not valid yet, look right
            }
        }
        return low; // Index of the first valid interval, or sortedIntervals.length if none exists
    }
    // Decides between skipping or taking based on max score, then lexicographical comparison
    private State getBetterState(State s1, State s2) {
        if (s1.score > s2.score) return s1;
        if (s2.score > s1.score) return s2;

        // Tie-breaker: Lexicographically smaller index list
        int minLen = Math.min(s1.indices.size(), s2.indices.size());
        for (int i = 0; i < minLen; i++) {
            int id1 = s1.indices.get(i);
            int id2 = s2.indices.get(i);
            if (id1 != id2) {
                return id1 < id2 ? s1 : s2;
            }
        }

        // If elements are identical up to minLen, choose shorter length
        return s1.indices.size() <= s2.indices.size() ? s1 : s2;
    }
}
