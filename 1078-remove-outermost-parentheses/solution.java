class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder("");
        String result = "";
        Deque<Character> stack = new ArrayDeque<>();
        stack.addFirst('0');
        int n = s.length();
        for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    stack.addFirst(ch);
                    String str = String.valueOf(ch);
                    sb.append(str);

                }
                else if (ch == ')') {
                    stack.removeFirst();
                    String str = String.valueOf(ch);
                    sb.append(str);
                }

                if (stack.peekFirst() == '0') {
                    sb.deleteCharAt(0);
                    sb.deleteCharAt(sb.length() - 1);
                    result += sb;
                    sb.setLength(0);
                }

        }
           
        return result;
        
    }
}
