class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long score = 0;
        // We want the maximum / biggest elements (Math.abs), absolute values in the array to be at the even position and the smallest to be at odd indices

        // In any length array of n, we must have exactly n / 2 indices that are even and n/2 that are odd given n is even
        // If n is odd, then we must have exactly n / 2 int div and n / 2 - 1 odd indices
        int size = 0;
        if (n % 2 == 0) {
            size = n / 2;
        }
        else {
            size = Math.round(n / 2); // Round it up 
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.add(Math.abs(num));
        }
        // First compute score using the largest numbers at the even indices so adding their squares to score
        for (int i = 0; i < n; i = i + 2) {
            int num = maxHeap.poll();
            score += (long) num * num;
   
        }
        // Deal with odd indices
        for (int i = 1; i < n; i = i + 2) {
                int num = maxHeap.poll();
                score -= (long) num * num;
        }



        return score;
        
        
    }
}
