class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        // O(N) / O(N log n) 
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        //[ [1, 2], [2, 3], [3, 5] , [6, 8], ...]
        List<int[]> intervals = new ArrayList(n);
        char c = 'a';
        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            if (first[charIdx] == -1) {
                first[charIdx] = i;
            }
            last[charIdx] = i;
        }

        // Loop through all chars 'a' - 'z', and if one was present in the string start expanding window to capture max substring which capture all occurrences of that char
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue;
            }

            int left = first[i];
            int right = last[i];
            boolean isValid = true;

            for (int j = left; j <= right; j++) {
                int charInside = s.charAt(j) - 'a';

                if (first[charInside] < left) {
                    isValid = false;
                    break;
                }
                right = Math.max(right, last[charInside]);

            }
            
            if (isValid) {
                intervals.add(new int[]{left, right});
            }
        }

        /* Sort 'intervals' by ending coordinate

        Create result list of strings
        Set lastEnd = -1

        For each [start, end] pair in 'intervals':
            If start > lastEnd:
                Get substring from 'start' to 'end' and add to result
                lastEnd = end

        Return result
                return maxSubstrings;
        */
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));
        List<String> result = new ArrayList<>();
        int lastEnd = -1;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start > lastEnd) {
                result.add(s.substring(start, end + 1));
                lastEnd = end;
            }
        }
        return result;
    }
}
