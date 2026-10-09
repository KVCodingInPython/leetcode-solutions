class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return ans;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.add(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int i = curr[1];
            int j = curr[2];

            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[j]);
            ans.add(pair);
            k--;

            if (j + 1 < nums2.length) {
                minHeap.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return ans;
    }
}
