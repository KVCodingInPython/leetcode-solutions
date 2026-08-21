class Solution {
    // k is 1 <= k <= 2^30
    // Pick  smallest number in the array, 'coins', store it in min
    // Smallest Number * k >= Biggest Number factor list, 'factors'
    // Then list factors of smallest number up to <= k. 
    // Pick largest number in array, 'coins', store it in max.
     public static long findKthSmallest(int[] coins, int k) {
        long min = coins[0];
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] < min) {
                min = coins[i];
            } 
        }
        long low = 1;
        long high = min * (long) k;
        while (low < high) {
            long middle = low + (high - low) / 2;
            if (countAmountsAtMost(middle, coins) >= k) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;

    }

    private static long countAmountsAtMost(long amount, int[] coins) {
        HashSet<Integer> uniqueCoins = new HashSet<>();
        for (int coin : coins) {
            uniqueCoins.add(coin);
        }

        int[] denominations = new int[uniqueCoins.size()];
        int denominationIndex = 0;
        for (int coin : uniqueCoins) {
            denominations[denominationIndex] = coin;
            denominationIndex += 1;
        }

        long count = 0;
        int subsetCount = 1 << denominations.length;
        for (int subset = 1; subset < subsetCount; subset++) {
            long leastCommonMultiple = 1;
            int selectedCoins = 0;
            boolean exceedsAmount = false;
            for (int i = 0; i < denominations.length; i++) {
                if ((subset & (1 << i)) != 0) {
                    selectedCoins += 1;
                    long divisor = gcd(leastCommonMultiple, denominations[i]);
                    long factor = denominations[i] / divisor;
                    if (leastCommonMultiple > amount / factor) {
                        exceedsAmount = true;
                        break;
                    }
                    leastCommonMultiple *= factor;
                }
            }
            if (!exceedsAmount) {
                long multiples = amount / leastCommonMultiple;
                if ((selectedCoins & 1) == 1) {
                    count += multiples;
                } else {
                    count -= multiples;
                }
            }
        }
        return count;
    }

    private static long gcd(long first, long second) {
        while (second != 0) {
            long remainder = first % second;
            first = second;
            second = remainder;
        }
        return first;
    }
}


