class Solution {
    public int stoneGameVIII(int[] stones) {
       int total_sum = 0;

       for (int i = 0; i < stones.length; i++) {
            total_sum += stones[i];
       }
       int best_difference = total_sum;
       for (int i = stones.length - 2; i >= 1; i--) {
            total_sum = total_sum - stones[i+1];
            best_difference = Math.max(best_difference, total_sum - best_difference);
       }

       return best_difference;

        

        
    }
}
