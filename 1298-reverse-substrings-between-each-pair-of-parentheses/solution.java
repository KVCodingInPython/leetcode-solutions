import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String reverseParentheses(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Save outer context to stack and start fresh buffer
                stack.push(current);
                current = new StringBuilder();
            } else if (c == ')') {
                // Reverse current level and attach to popped outer context
                current.reverse();
                current = stack.pop().append(current);
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
}
