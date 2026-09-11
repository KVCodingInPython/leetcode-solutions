class Solution {
    public int totalNumbers(int[] digits) {
        // Step 1: Count digit frequencies in O(N) time
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }

        int validNumbersCount = 0;

        // Step 2: Iterate over all possible 3-digit even numbers (100 to 998)
        for (int num = 100; num < 1000; num += 2) {
            int h = num / 100;       // Hundreds digit
            int t = (num / 10) % 10; // Tens digit
            int u = num % 10;        // Units digit

            // Temporarily decrement frequencies to verify availability
            count[h]--;
            count[t]--;
            count[u]--;

            // If no digit was over-used (frequency didn't drop below 0), it's valid
            if (count[h] >= 0 && count[t] >= 0 && count[u] >= 0) {
                validNumbersCount++;
            }

            // Restore frequencies for the next iteration
            count[h]++;
            count[t]++;
            count[u]++;
        }

        return validNumbersCount;
    }
}
