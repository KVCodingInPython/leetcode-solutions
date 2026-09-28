class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int depth = 0;
        int max_depth = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                depth += 1;

            }
            else if (s.charAt(i) == ')') {
                max_depth = Math.max(depth, max_depth);
                depth -= 1;
            }

        }
        return max_depth;
    }
}
