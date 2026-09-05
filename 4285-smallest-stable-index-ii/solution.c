int firstStableIndex(int* nums, int numsSize, int k) {
        // Find max prefix search left to right comparing each index with current max
        int prefixMax[numsSize];
        prefixMax[0] = nums[0];
        for (int i = 1; i < numsSize; i++) {
            prefixMax[i] = fmax(prefixMax[i - 1], nums[i]);
        }
        int suffixMin[numsSize];
        suffixMin[numsSize - 1] = nums[numsSize - 1];
        // Search RIGHT to LEFT for min suffix
        for (int i = numsSize - 2; i >= 0; i--) {
            suffixMin[i] = fmin(suffixMin[i + 1], nums[i]);
        }

        for (int i = 0; i < numsSize; i++) {
            if (prefixMax[i] - suffixMin[i] <= k) {
                return i;
            }
        }
        return -1;
    }
