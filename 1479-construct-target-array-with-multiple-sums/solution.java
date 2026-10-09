class Solution {
    public boolean isPossible(int[] target) {
        int n = target.length;
        // loop through target to find initial sum and maximum in array
        // Pointer for accessing elements linearly in target

        if (n == 1) {
            return target[0] == 1;
        }
        long total_sum = 0;
        total_sum = sum(target, total_sum);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : target) {
            maxHeap.add(num);
        }
        while (true) {
            int largest = maxHeap.poll();
            long rest_sum = total_sum - largest;

            if (largest == 1 || rest_sum == 1) {
                return true;
            }
            if (largest <= rest_sum || rest_sum == 0 || largest % rest_sum == 0) {
                return false;
            }

            int new_val = (int) (largest % rest_sum);
            total_sum = rest_sum + new_val;
            maxHeap.add(new_val);
        }
    }

    public long sum(int[] arr, long total_sum) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            total_sum += arr[i];
        }
        return total_sum;
    }
}
