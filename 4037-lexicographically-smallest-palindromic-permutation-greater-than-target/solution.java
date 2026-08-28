class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int [] count = new int[26];

        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Validate palindrome capability
        int oddCount = 0;
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
        }
        if (oddCount > 1) {
            return "";
        }

        int halfLen = n / 2;
        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }
        // --- STEP 1: Attempt Exact Match for First Half ---
        int[] tempHalf = halfCount.clone();
        char[] firstHalf = new char[halfLen];
        boolean exactPossible = true;

        for (int i = 0; i < halfLen; i++) {
            int targetIdx = target.charAt(i) - 'a';
            if (tempHalf[targetIdx] > 0) {
                firstHalf[i] = target.charAt(i);
                tempHalf[targetIdx]--;
            }
            else {
                exactPossible = false;
                break;
            }
        }

        if (exactPossible) {
            String candidate = buildFullPalindrome(firstHalf, midChar, n);
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        // --- OPTION 2: Match target prefix up to index (i - 1), and branch larger at index i ---
        // We test branching at position i from (halfLen - 1) down to 0.
        for (int i = halfLen - 1; i >= 0; i--) {
            tempHalf = halfCount.clone();
            boolean prefixOk = true;
            // Re-verify if we can form target's prefix up to index (i - 1)
            for (int k = 0; k < i; k++) {
                int tIdx = target.charAt(k) - 'a';
                if (tempHalf[tIdx] > 0) {
                    firstHalf[k] = target.charAt(k);
                    tempHalf[tIdx]--;
                }
                else {
                    prefixOk = false;
                    break;
                }
            }

            if (!prefixOk) continue; // Can't match prefix up to index i-1, try an earlier index

            // Try to place a character strictly larger than target[i] at index i
            int targetIdx = target.charAt(i) - 'a';
            for (int c = targetIdx + 1; c < 26; c++) {
                if (tempHalf[c] > 0) {
                    firstHalf[i] = (char) ('a' + c);
                    tempHalf[c]--;

                    // Greedily fill remaining slots with smallest available characters
                    int ptr = i + 1;
                    for (int ch = 0; ch < 26; ch++) {
                        while (tempHalf[ch] > 0 && ptr < halfLen) {
                            firstHalf[ptr++] = (char) ('a' + ch);
                            tempHalf[ch]--;
                        }
                    }
                    // Any branch strictly larger at position i guarantees full string > target
                    return buildFullPalindrome(firstHalf, midChar, n);
                }

            }

        }

        return ""; // Impossible to construct a palindrome >= target
    }

    private String buildFullPalindrome(char[] firstHalf, char midChar, int totalLen) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstHalf);
        if (totalLen % 2 != 0) {
            sb.append(midChar);
        }
        for (int i = firstHalf.length - 1; i >= 0; i--) {
            sb.append(firstHalf[i]);
        }
        return sb.toString();
    }
}
