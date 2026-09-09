long long countCommas(long long n) {
    long long comma_count = 0;
    long long base = 1000;
    int commas = 1;

    while (n >= base) {
        if (n > (base * 1000) - 1) {
            comma_count += ((base * 1000) - base) * commas;
        }
        else {
            comma_count += ((n - base) + 1) * commas;
        }
        commas++;
        base *= 1000;
    }
    return comma_count;
    
}
