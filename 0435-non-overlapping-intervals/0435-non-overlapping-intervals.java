class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1 ; i < intervals.length ; i++){
            int current_start = intervals[i][0];
            int current_end = intervals[i][1];

            if (current_start < end) {
                // Overlap, so remove one
                count++;
                // Keep the interval with smaller end to minimize future overlaps
                end = Math.min(end, current_end);
            } else {
                // No overlap, update end
                end = current_end;
            }
        }
        return count;
    }
}