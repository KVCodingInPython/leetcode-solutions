class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int n = s.length();
        boolean[] ans = new boolean[strs.length];

        // 1. Suffix count of '0' in string s
        int[] sufS = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sufS[i] = sufS[i + 1] + (s.charAt(i) == '0' ? 1 : 0);
        }
        int totalZerosS = sufS[0];

        // 2. Process each query string
        for (int q = 0; q < strs.length; q++) {
            char[] target = strs[q].toCharArray();
            int fixedZeros = 0;
            int qMarks = 0;

            for (char c : target) {
                if (c == '0') fixedZeros++;
                else if (c == '?') qMarks++;
            }

            int zerosNeeded = totalZerosS - fixedZeros;

            // Cannot match if fixed '0's exceed totalZerosS or if not enough '?' exist
            if (zerosNeeded < 0 || zerosNeeded > qMarks) {
                ans[q] = false;
                continue;
            }

            // Greedy Placement:
            // To make sufT[i] <= sufS[i] as easy as possible to satisfy,
            // place the needed '0's as far LEFT as possible in target.
            int zerosLeftToFill = zerosNeeded;
            for (int i = 0; i < n; i++) {
                if (target[i] == '?') {
                    if (zerosLeftToFill > 0) {
                        target[i] = '0';
                        zerosLeftToFill--;
                    } else {
                        target[i] = '1';
                    }
                }
            }

            // 3. Verify the suffix condition: sufS[i] >= sufT[i] for all i
            boolean isValid = true;
            int currentZerosT = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (target[i] == '0') {
                    currentZerosT++;
                }
                if (sufS[i] < currentZerosT) {
                    isValid = false;
                    break;
                }
            }

            ans[q] = isValid;
        }

        return ans;
    }
}
