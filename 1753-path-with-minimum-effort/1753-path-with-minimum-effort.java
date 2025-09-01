class Pair {
    int distance;
    int row;
    int col;

    Pair(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;
        int ans = Integer.MAX_VALUE;
        int[][] dist_mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist_mat[i][j] = Integer.MAX_VALUE;
            }
        }
        dist_mat[0][0] = 0;
        int diff = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair -> Pair.distance));
        pq.add(new Pair(0, 0, 0));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int distance = pair.distance;
            int row = pair.row;
            int col = pair.col;

            if (row == m - 1 && col == n - 1) {
                return distance;
            }
            int[] d_row = { -1, 0, 1, 0 };
            int[] d_col = { 0, 1, 0, -1 };

            for (int i = 0; i < 4; i++) {
                int r = row + d_row[i];
                int c = col + d_col[i];

                if (r < 0 || r >= m || c < 0 || c >= n) {
                    continue;
                } else {
                    diff = Math.max(distance , Math.abs(heights[row][col] - heights[r][c]));
                    if (diff < dist_mat[r][c]) {
                        dist_mat[r][c] = diff;
                        pq.add(new Pair(diff, r, c));
                    }
                }

            }
        }
        return 0;
    }

}