class Solution {
    public int reverseDegree(String s) {
        int product = 0;
        for (int i = 0; i < s.length(); i++) {
            int rev = 26 - (s.charAt(i) - 'a');
            int position = i + 1;
            product += (position * rev);
        }
        return product;
        
    }
}
