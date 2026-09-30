class Solution {
    public int[] maxDepthAfterSplit(String seq)
    // <= 10^4 len(seq), use O(N^2) / O(N) / O(NLOGN) / O(LOGN) / O(1)
    {
        // O(1) Operations: Base Cases and edge cases
        int n = seq.length();
        int current_depth = 0;
        int total_depth = 0;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                result[i] = current_depth % 2;
                ++current_depth;
            }
            else if (seq.charAt(i) == ')') {
                --current_depth;
                result[i] = current_depth % 2;
            }
        }
        return result;
    }
}
