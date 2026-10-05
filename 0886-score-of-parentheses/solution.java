class Solution {
    public int scoreOfParentheses(String s) {
        // Base Case: s.length() == 2 == '()'
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(0);
        int score = 0;
        
        int n = s.length();
        if (n == 2) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.addFirst(0);
            }
            else {
                int innerScore = stack.removeFirst();
                int outerScore = stack.removeFirst();

                int currentScore = Math.max(2 * innerScore, 1);

                stack.push(outerScore + currentScore);
            }
        }
        return stack.pop();
    }

}
