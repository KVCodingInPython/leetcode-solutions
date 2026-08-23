class Solution {
    public boolean sumGame(String num) {
        int num_low_half_bound = (num.length() / 2) - 1;
        int num_top_half_bound = (num.length() / 2);
        // Difference between digit sums of two halves
        int sumDiff = 0;
        // Difference between number of '?' in two halves
        int qDiff = 0;

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '?') {
                qDiff += ( i < (num.length() / 2)) ? 1 : -1;
            }
            else {
                sumDiff += (i < (num.length() / 2)) ? (num.charAt(i) - '0') : (-(num.charAt(i) - '0'));
            }
        }

        if (qDiff % 2 != 0) {
            return true;
        }
        
        return 2 * sumDiff != -9 * qDiff;
    }
}
