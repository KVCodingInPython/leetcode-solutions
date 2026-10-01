
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        HashMap<Character, Character> bracketEquivalents = new HashMap<>();
        bracketEquivalents.put('(', ')');
        bracketEquivalents.put('[', ']');
        bracketEquivalents.put('{', '}');
        if (s.charAt(0) == ']' || s.charAt(0) == '}' || s.charAt(0) == ')' || s == "") {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char character = s.charAt(i);
            if (character == '(' || character == '[' || character == '{') {
                stack.addFirst(character);
            }
            // Deal with closing brackets
            else if (character == ')' || character == ']' || character == '}') {
                if (!stack.isEmpty()) {
                    char removed_char = stack.removeFirst();
                    char closing_bracket = bracketEquivalents.get(removed_char);
                    if (character != closing_bracket) {
                        return false;
                    }
                }
                else {
                    return false;
                }
                
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
