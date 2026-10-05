class Solution {
    public int[] finalPrices(int[] prices) {
        /* int[] answer = new int[prices.length];
        int left = 0;
        int right = 1;
        while (left != prices.length && right != prices.length) {
            if (prices[right] <= prices[left]) {
                answer[left] = prices[left] - prices[right];
                left += 1;
                right = left + 1;
                continue;
            }
            answer[left] = prices[left];
            left += 1;
            right = left + 1;
        }
        return answer;
        */
        int n = prices.length;

        for (int i = 0; i <= n - 2; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        
        return prices;
        
    }
}
