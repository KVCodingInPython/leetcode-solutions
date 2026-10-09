class Solution {
    private static final int MOD = 1_000_000_007;

    public int countGoodStrings(long n) {
        if (n == 1) return 2;
        if (n == 2) return 2;
        
        // Matrix for Fibonacci recurrence: F(n) = F(n-1) + F(n-2)
        long[][] base = {
            {1, 1},
            {1, 0}
        };
        
        // For T(n), raising base to power (n - 2)
        long[][] res = matrixPower(base, n - 2);
        
        // T(n) = res[0][0] * T(2) + res[0][1] * T(1)
        // Since T(2) = 2 and T(1) = 2:
        long ans = (res[0][0] * 2 + res[0][1] * 2) % MOD;
        return (int) ans;
    }
    
    private long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                long sum = 0;
                for (int k = 0; k < 2; k++) {
                    sum = (sum + A[i][k] * B[k][j]) % MOD;
                }
                C[i][j] = sum;
            }
        }
        return C;
    }
    
    private long[][] matrixPower(long[][] A, long p) {
        long[][] res = {
            {1, 0},
            {0, 1}
        }; // Identity matrix
        
        while (p > 0) {
            if ((p & 1) == 1) {
                res = multiply(res, A);
            }
            A = multiply(A, A);
            p >>= 1;
        }
        return res;
    }
}
