class Solution {
    public boolean checkDivisibility(int n) {
        String s = Integer.toString(n);
        int digit_sum = 0;
        int digit_product = 1;
        int total_sum = 0;
        if (s.length() == 1) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            digit_sum = digit_sum + digit;
            digit_product = digit_product * digit;
        }
        System.out.println(digit_sum);
        System.out.println(digit_product);
        total_sum = digit_sum + digit_product;
        System.out.println(total_sum);

        if (total_sum % n == 0) {
            return true;
        }
        else if (n % total_sum == 0) {
            return true;
        }
        else {
            return false;
        }
        

        
    }
}
