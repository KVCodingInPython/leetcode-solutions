import java.util.*;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Try matching a prefix of length `i` (from n-1 down to 0)
        for (int i = n - 1; i >= 0; i--) {
            // Check if the prefix target[0...i-1] can be formed using available frequencies
            int[] currentFreq = freq.clone();
            boolean canFormPrefix = true;

            for (int k = 0; k < i; k++) {
                char ch = target.charAt(k);
                if (currentFreq[ch - 'a'] > 0) {
                    currentFreq[ch - 'a']--;
                } else {
                    canFormPrefix = false;
                    break;
                }
            }

            if (!canFormPrefix) continue;

            // Find the smallest character strictly greater than target[i]
            char targetChar = target.charAt(i);
            for (char c = (char) (targetChar + 1); c <= 'z'; c++) {
                if (currentFreq[c - 'a'] > 0) {
                    // Valid divergence point found!
                    currentFreq[c - 'a']--;

                    // Build the final string
                    StringBuilder sb = new StringBuilder();
                    sb.append(target.substring(0, i));
                    sb.append(c);

                    // Append remaining characters in ascending order
                    for (int ch = 0; ch < 26; ch++) {
                        while (currentFreq[ch] > 0) {
                            sb.append((char) ('a' + ch));
                            currentFreq[ch]--;
                        }
                    }

                    return sb.toString();
                }
            }
        }

        return ""; // No permutation is strictly greater
    }
}
