int minKBitFlips(int* nums, int numsSize, int k) {
    // [0, 1, 0] -> 0 | 1 | 0 => if (k == 1) // Base Case then, just loop and find element equal to '0', if '0', just add countFlips += 1
    // k = 2: [1, 1, 0] -> 11 | 10 -> for loop, AT LEAST IF EXACTLY ONE ZERO EXISTS IN A CONTIGUOUS SUBARRAY, then return -1 immediately

    // [0, 0, 0, 1, 0, 1, 1, 0] -> 000 | 001 | 010 | 101 | 011 | 110
    // First check if possible to flip at least one subarray of size k in any way
    int currently_active_flips = 0;
    int flip_count = 0;
    // Greedy approach, if find any 0, just flip it and add to count
    for (int i = 0; i < numsSize; i++) {

        if (i >= k && nums[i - k] == 2) { // or isFlipped[i - k] == 1
            currently_active_flips--;
        }
        // Greedy check
        if (nums[i] == (currently_active_flips % 2)) {
            // Boundary check
            if (i + k > numsSize) {
                return -1;
            }
            flip_count += 1;
            currently_active_flips += 1;
            nums[i] = 2;
        }
    }


    return flip_count;
}
