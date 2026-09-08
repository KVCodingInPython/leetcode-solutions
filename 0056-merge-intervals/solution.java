class Solution {
    public int[][] merge(int[][] intervals) {
        // int[i][j] intervals, with i entries and j (number of elements / length of entry)
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] nextInterval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            if (nextStart <= currentEnd) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            }
            else {
                currentInterval = nextInterval;
                merged.add(currentInterval);
            }
        }
      

        return merged.toArray(new int[merged.size()][]);
        
    }
}
