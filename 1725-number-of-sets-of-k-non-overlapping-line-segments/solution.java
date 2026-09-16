class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX = 2005; // Max possible value for (n - 1 + k)
    private static long[] fact;
    private static long[] invFact;
    private static boolean isPrecomputed = false;

    // Call this once to precompute factorials for O(1) queries
    private static void precompute() {
        if (isPrecomputed) return; // Prevent re-running across multiple LeetCode test cases
        
        fact = new long[MAX];
        invFact = new long[MAX];
        
        fact[0] = 1;
        invFact[0] = 1;
        
        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        
        // Compute the modular inverse of the largest factorial using Fermat's Little Theorem
        invFact[MAX - 1] = power(fact[MAX - 1], MOD - 2);
        
        // Work backwards to fill the rest of the inverse factorials
        for (int i = MAX - 2; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
        
        isPrecomputed = true;
    }

    // O(1) combination query
    private static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    // Binary exponentiation for O(log MOD) modular inverse
    private static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    public int numberOfSets(int n, int k) {
        // 1. Precompute factorials if not already done
        precompute();
        
        // 2. Set up the parameters based on the combinatorics formula
        int totalN = n - 1 + k;
        int totalR = 2 * k;
        
        // 3. Query the answer and return as integer
        return (int) nCr(totalN, totalR);
    }
}

