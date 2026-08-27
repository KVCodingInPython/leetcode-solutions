class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<String> lexicographical_numbers = new ArrayList<>(n);
        List<Integer> lexicalOrdered = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            String str1 = Integer.toString(i);
            lexicographical_numbers.add(str1);
        }
        Collections.sort(lexicographical_numbers);
        for (String s: lexicographical_numbers) {
            lexicalOrdered.add(Integer.valueOf(s));
        }
        return lexicalOrdered;
        
        
        
    }
}
