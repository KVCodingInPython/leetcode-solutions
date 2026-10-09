class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (x != y) {
                int y_new = y - x;
                maxHeap.add(y_new);
            }
        }
        if (maxHeap.size() == 0) {
            return 0;
        }
        return maxHeap.poll();
    }
}
