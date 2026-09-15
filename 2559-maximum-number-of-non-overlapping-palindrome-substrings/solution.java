class Solution {
    public int maxPalindromes(String s, int k) {
        int palindrome_count = 0;
        int n = s.length();
        int lastEnd = -1;
        for (int i = 0; i < n; i++) {
            // Check odd-lengthed palindromes, centered exactly at one position, 'i'
            int left = i;
            int right = i;

            while (left > lastEnd && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len >= k) {
                    palindrome_count++;
                    lastEnd = right;
                    break;
                }
                left--;
                right++;
            }

            // Even length palindromes have centers between i, and i +1, so left and right are i, i + 1, respectively
            left = i;
            right = i + 1;

            while (left > lastEnd && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len >= k) {
                    palindrome_count++;
                    lastEnd = right;
                    break;
                }
                left--;
                right++;
            }
        }
        return palindrome_count;
    }
}
