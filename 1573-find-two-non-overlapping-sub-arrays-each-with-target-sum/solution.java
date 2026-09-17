import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE / 2; // Avoid overflow when adding lengths
        
        // minLen[i] stores the minimum length of a target subarray ending at or before index i
        int[] minLen = new int[n];
        Arrays.fill(minLen, INF);
        
        int ans = INF;
        int left = 0;
        int currentSum = 0;
        
        for (int right = 0; right < n; right++) {
            currentSum += arr[right];
            
            // Shrink window if sum exceeds target
            while (currentSum > target) {
                currentSum -= arr[left];
                left++;
            }
            
            // Found a valid subarray with sum equal to target
            if (currentSum == target) {
                int currLen = right - left + 1;
                
                // Check if a non-overlapping valid subarray exists to the left
                if (left > 0 && minLen[left - 1] != INF) {
                    ans = Math.min(ans, currLen + minLen[left - 1]);
                }
                
                // Update minLen for current position
                minLen[right] = (right > 0) ? Math.min(minLen[right - 1], currLen) : currLen;
            } else {
                // Carry forward the best minimum length found so far
                minLen[right] = (right > 0) ? minLen[right - 1] : INF;
            }
        }
        
        return ans >= INF ? -1 : ans;
    }
}
