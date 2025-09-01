class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int m = intervals.length;
        int count = 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); // descending order for 1st index
            }
            return Integer.compare(a[0], b[0]); // ascending order for 0th index
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < m; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];

            if (left <= a && b <= right) {
                count++;
            }
            left = Math.min(a, left);
            right = Math.max(b, right);
        }
        return m - count;
    }
}