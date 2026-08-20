class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> duplicateLetters = new HashSet<Character>();
        int left = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            while (duplicateLetters.contains(s.charAt(i))) {
                duplicateLetters.remove(s.charAt(left));
                left = left + 1;
            }
            duplicateLetters.add(s.charAt(i));
            max = Math.max(max, i - left + 1);
        }
            

        return max;
        
    }
}
