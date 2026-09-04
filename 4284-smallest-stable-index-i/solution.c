int firstStableIndex(int* nums, int numsSize, int k) {
    int* suff_min = (int*)malloc(numsSize * sizeof(int));
    if (!suff_min) return -1;

    suff_min[numsSize - 1] = nums[numsSize - 1];
    for (int i = numsSize - 2; i >= 0; i--) {
        if (nums[i] < suff_min[i + 1]) {
            suff_min[i] = nums[i];
        }
        else {
            suff_min[i] = suff_min[i + 1];
        }
    }
    int prefMax = nums[0];
    int result = -1;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] > prefMax) {
            prefMax = nums[i];
        }
        int score = prefMax - suff_min[i];

        if (score <= k) {
            result = i;
            break;
        }
    }
    free(suff_min);
    return result;
}
