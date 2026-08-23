class Solution {
    public boolean isPalindromic(String s) {
        String binary = "";
        
        for (int i = 0; i < s.length(); i++) {
            int ascii_num = s.charAt(i);
            System.out.println(ascii_num);
            System.out.println(Integer.toBinaryString(ascii_num));
            String binary_string_num = "0";
            binary_string_num = binary_string_num.concat(Integer.toBinaryString(ascii_num));
            binary = binary.concat(binary_string_num);
            System.out.println(binary);
        }
        int right = binary.length() - 1;

        for (int left = 0; left < right; left++) {
            if ((binary.charAt(left) == binary.charAt(right))) {
                right -= 1;
            }
            else {
                return false;
            }
        }

    return true;
    }
    
}
