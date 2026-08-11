
class Solution {
    public boolean isPalindrome(int x) {

    String y = Integer.toString(x);

    StringBuilder RevX = new StringBuilder();

    for (int i = y.length()-1; i >= 0; i--) {
        RevX.append(y.charAt(i));
    }

    return RevX.toString().equals(y);
        
    }
}
