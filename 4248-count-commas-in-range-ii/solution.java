class Solution {
    public long countCommas(long n) {
        // 1000 <= n <= 9999: 1 comma each number -> 1 comma in total
        // 10,000 <= n <= 99,999: 1 comma each number -> 1 comma in total
        // 10^6 : 1,000,000 <= n <= 9, 999, 999: 2 commas each number -> 999, 999 - 1000 + 1 = 
        // 10^9: 1, 000, 000, 000: 3 commas each number -> 

        long ans = 0;
        long base = 1000;
        int commas = 1;

        while (base <= n) {
            long end = base * 1000 - 1;
            long count = Math.min(n, end) - base + 1;
            ans += count * commas;
            base *= 1000;
            commas++;
        }
        return ans;
    }
}
