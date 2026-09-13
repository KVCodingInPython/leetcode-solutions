class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        // Convert each row of both images into integer bitmasks
        int[] A = new int[n];
        int[] B = new int[n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                A[r] = (A[r] << 1) | img1[r][c];
                B[r] = (B[r] << 1) | img2[r][c];
            }
        }

        int maxOverlap = 0;

        // try all possible row and column shifts
        for (int rowShift = 0; rowShift < n; rowShift++) {
            for (int colShift = 0; colShift < n; colShift++) {

                // Case 1: Shift img1 DOWN by rowShift and RIGHT/LEFT by colShift
                maxOverlap = Math.max(maxOverlap, countOverlap(A, B, rowShift, colShift, n));
                
                // Case 2: Shift img1 UP by rowShift and RIGHT/LEFT by colShift
                maxOverlap = Math.max(maxOverlap, countOverlap(B, A, rowShift, colShift, n));
            }
        }
        return maxOverlap;
            
    }

    private int countOverlap(int[] A, int[] B, int rowShift, int colShift, int n) {
        int countRight = 0;
        int countLeft = 0;

        for (int r = rowShift; r < n; r++) {
            // Shift row right: bits move toward lower positions
            countRight += Integer.bitCount((A[r] >> colShift) & B[r - rowShift]);
            
            // Shift row left: bits move toward higher positions
            countLeft += Integer.bitCount((A[r] << colShift) & B[r - rowShift]);
        }

        return Math.max(countLeft, countRight);
    }
}

