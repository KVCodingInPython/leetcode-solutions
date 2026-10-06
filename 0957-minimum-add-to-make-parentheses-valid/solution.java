class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        int min_operations = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.addFirst(ch);
            }
            else {
                if (stack.size() != 0) {
                    stack.removeFirst();
                }
                else {
                    min_operations += 1;
                }

            }
        }
        return min_operations + stack.size();


    }
}
