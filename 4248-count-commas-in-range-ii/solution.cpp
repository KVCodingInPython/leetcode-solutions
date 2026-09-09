class Solution {
public:
// Base number, 1000, while (n >= base) then do comma calc
// Increase base by 1000 each time in loop
// Set max and min range based on current base: min = base; max = (base * base) - 1
    long long countCommas(long long n) {
        long long base = 1000;
        long long comma_count = 0;
        int commas = 1;
        while (n >= base) {
            if (n > ((base * 1000) - 1)) {
                comma_count += ((base * 1000) - base) * commas;
            }
            else {
                comma_count += ((n - base) + 1) * commas;
            }

            if (base >= 1000000000000000LL) { 
                break; 
            }

            commas++;
            base *= 1000;
        }
        return comma_count;
    }
};
