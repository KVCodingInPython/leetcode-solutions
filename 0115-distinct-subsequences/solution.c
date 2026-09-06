int numDistinct(char* s, char* t) {
        int m = strlen(s);
        int n = strlen(t);

        unsigned long long** subsequence_table = (unsigned long long**)malloc((m + 1) * sizeof(unsigned long long*));
        for (int i = 0; i <=m ; i++) {
            subsequence_table[i] = (unsigned long long*)calloc((n+1), sizeof(unsigned long long));
        }

        // Base Case:
        // if t is empty : "", then at least one subsequence of s matches
        for (int i = 0; i <= m; i++) {
            subsequence_table[i][0] = 1;
            
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s[i - 1] == t[j - 1]) {
                    subsequence_table[i][j] = subsequence_table[i-1][j-1] + subsequence_table[i - 1][j];
                }
                else {
                    subsequence_table[i][j] = subsequence_table[i - 1][j];
                }
            }
        }

        unsigned long long result = subsequence_table[m][n];

        // Free allocated memory
        for (int i = 0; i <= m; i++) {
            free(subsequence_table[i]);
        }
        free(subsequence_table);
        return (int)result;
}

