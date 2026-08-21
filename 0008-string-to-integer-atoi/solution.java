class Solution {
        public static int myAtoi(String s) {

            boolean negative = false;
            int Pointer = 0;
            long Number = 0;
            int digit = 0;

            // Whitespace check
            s = s.trim();

            if (s.length() == 0) {
                return 0;
            }

            // Signedness check
            if (s.charAt(0) == '-') {
                negative = true;
                Pointer += 1;
            }
            if (s.charAt(0) == '+') {
                Pointer += 1;
            }
    

            // Conversion check
        
            while ((Pointer < s.length()) && (Character.isDigit(s.charAt(Pointer)))) {
                digit = s.charAt(Pointer) - '0';
                System.out.println(digit);
                // Rounding so within 32-bit range: {-2^31, ... , 2^31 - 1}.
                if (Number > (Integer.MAX_VALUE - digit) / 10) {
                    if (negative) {
                        Number = Integer.MIN_VALUE;
                        return (int) Number;
                    }
                    else {
                        Number = Integer.MAX_VALUE;
                        return (int) Number;
                    }
                }
        

                Number = (Number * 10) + digit;
                System.out.println(Number);
                Pointer += 1;
            }
            if (negative) {
                Number = -1 * Number;
            }
            return (int) Number;

    }
}

