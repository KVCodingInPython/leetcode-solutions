class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int target = tickets[k];
        int n = tickets.length;
        int total_contribution = 0;
        for (int i = 0; i < n; i++) {
            if (i <= k) {
                total_contribution += Math.min(tickets[i], target);

            }
            else if (i > k) {
                total_contribution += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return total_contribution;
        
    }
}
