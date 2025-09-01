class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int rows = points.length;
        int arrows = 1;
        int end = points[0][1];
        int current_row = 1;
        while (current_row < rows) {
            if (points[current_row][0] <= end) {
                end = Math.min(end, points[current_row][1]);
            } else {
                arrows++;
                end = points[current_row][1];
            }

            current_row++;
        }
        return arrows;
    }
}