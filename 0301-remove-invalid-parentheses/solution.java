class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        int rem_open = 0;
        int rem_close = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                rem_open += 1;
            }
            else if (ch == ')') {
                if (rem_open > 0) {
                    rem_open -= 1;
                }
                else {
                    rem_close += 1;
                }
            }

        }
        Set<String> results = new HashSet<>();
        StringBuilder path = new StringBuilder();

        // Step 2: Backtracking DFS
        backtrack(s, 0, path, 0, rem_open, rem_close, results);

        return new ArrayList<>(results);
    }

    public void backtrack(String s, int index, StringBuilder path, int balance, int rem_open, int rem_close, Set<String> results) {
        if (balance < 0) {
            return;
        }

        if (index == s.length()) {
            if (rem_open == 0 && rem_close == 0 && balance == 0) {
                results.add(path.toString());
            }
            return;
        }

        char current_char = s.charAt(index);
        int path_len = path.length();

        // Choice 1 : Remove Character
        if (current_char == '(' && rem_open > 0) {
            backtrack(s, index + 1, path, balance, rem_open - 1, rem_close, results);
        }
        else if (current_char == ')' && rem_close > 0) {
            backtrack(s, index + 1, path, balance, rem_open, rem_close - 1, results);
        }

        // CHOICE 2: KEEP current character
        path.append(current_char);
        if (current_char == '(') {
            backtrack(s, index + 1, path, balance + 1, rem_open, rem_close, results);
        } else if (current_char == ')') {
            backtrack(s, index + 1, path, balance - 1, rem_open, rem_close, results);
        } else {
            backtrack(s, index + 1, path, balance, rem_open, rem_close, results);
        }

        // Backtrack
        path.setLength(path_len);

        return;
    }
}
