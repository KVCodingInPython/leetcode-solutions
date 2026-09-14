class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] result = new int[n][n];

        // 3. Process every element (i, j) and compute its final resting place
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                // 1. Calculate the final column index after moving LEFT
                int newCol = (j - rowShift[i] % n + n) % n;
                
                // 2. Calculate the final row index after moving UP 
                // Note: Use colShift[newCol] because the element is now in newCol!
                int newRow = (i - colShift[newCol] % n + n) % n;

                // Assign original element directly to its destination in the new grid
                result[newRow][newCol] = grid[i][j];
            }
        }
        return result;
    }
}
