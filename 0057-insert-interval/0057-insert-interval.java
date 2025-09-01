import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> output = new ArrayList<>();
        int i = 0, m = intervals.length;

        // left
        while (i < m && intervals[i][1] < newInterval[0]) {
            output.add(intervals[i]);
            i++;
        }

        // intersecting
        while (i < m && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        output.add(newInterval);

        // right
        while (i < m) {
            output.add(intervals[i]);
            i++;
        }

        return output.toArray(new int[output.size()][]);
    }
}
