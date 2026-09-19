class Solution {
    public String addBinary(String a, String b) {
        // First make a and b have same length if one is less than the other add '0's
        StringBuilder result = new StringBuilder();
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            // Append binary bit (sum % 2)
            result.append(sum % 2);
            // Update carry (sum / 2)
            carry = sum / 2;


        }

        return result.reverse().toString();
    }
}
