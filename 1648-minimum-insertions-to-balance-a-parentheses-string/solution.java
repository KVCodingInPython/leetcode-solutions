class Solution {
    public int minInsertions(String s) {
        int open_count = 0;
        int n = s.length();
        int minimum_insertions = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open_count += 1;
            }
            else {
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++;
                }
                else {
                    minimum_insertions += 1;
                }

                if (open_count > 0) {
                    open_count--;
                }
                else {
                    minimum_insertions += 1;
                }
            }
        }

        // s = "(()))" -> open = 2, close = 3
        return minimum_insertions + (open_count * 2);
    }
}
