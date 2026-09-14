/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** cyclicShift(int n, int** grid, int gridSize, int* gridColSize, int* rowShift, int rowShiftSize, int* colShift, int colShiftSize, int* returnSize, int** returnColumnSizes) {
    // Set up return metadata for function caller
    *returnSize = n;
    *returnColumnSizes = (int*) malloc(sizeof(int) * n);
    
    // 2. Allocate memory for the new shifted result grid
    int** result = (int**)malloc(n * sizeof(int*));
    for (int i = 0; i < n; i++) {
        (*returnColumnSizes)[i] = n;
        result[i] = (int*)malloc(n * sizeof(int));
    }

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
