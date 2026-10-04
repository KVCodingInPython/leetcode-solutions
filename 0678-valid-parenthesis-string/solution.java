public class Solution {
    public boolean checkValidString(String s) {
        int mask = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                mask = mask << 1;
            }
            else if (ch == ')') {
                mask = mask >> 1;
            }
            else {
                mask = (mask << 1) | mask | (mask >> 1);
            }
            if (mask == 0) {
                return false;
            }
        }
        return (mask & 1) != 0;
    }
}
