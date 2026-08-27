class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> letterFrequency = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            letterFrequency.put(s.charAt(i), letterFrequency.getOrDefault(s.charAt(i), 0) + 1);
        }
        System.out.println(letterFrequency);

        for (int i = 0; i < s.length(); i++) {
            if (letterFrequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
