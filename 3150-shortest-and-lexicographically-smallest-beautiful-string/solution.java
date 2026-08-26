class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        // Check if s has any beautiful substrings
        List<Integer> indices = new ArrayList<>();
        String result = "";
        int right = 0;
        int ones_count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                indices.add(i);
                right += 1;
            }
        }
        if (indices.size() < k) {
            return "";
        }
        System.out.println(indices);

        for (int i = 0; i <= indices.size() - k; i++) {
            int start = indices.get(i);
            int end = indices.get(i + k - 1);

            String substr = s.substring(start, end + 1);

            if (result.isEmpty() || substr.length() < result.length()) {
                result = substr;
            }
            else if (substr.length() == result.length() && substr.compareTo(result) < 0) {
                result = substr;
            }
        }
        return result; 
    }
}
