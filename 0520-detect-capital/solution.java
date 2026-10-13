class Solution {
    public boolean detectCapitalUse(String word) {
        int capital_count = 0;
        int lowercase_count = 0;
        int n = word.length();
        // First check if first letter in word is a capital letter ie must have an ASCII value such that 65 <= char <= 90
        // Capital count must either equal the length of entire word, or just equal to 1 so check this at the end of for loop
        // All letters must be lowercase for the second case to return true
        // Otherwise return false

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            int ascii_value = (int) ch;
            if (65 <= ascii_value && ascii_value <= 90) {
                capital_count += 1;
            }
            else {
                lowercase_count += 1;
            }
        }

        if (capital_count == 1 && (word.charAt(0) >= 65 && word.charAt(0) <= 90) || capital_count == n) {
            return true;
        }

        if (lowercase_count == n) {
            return true;
        }

        return false;
    }
}
