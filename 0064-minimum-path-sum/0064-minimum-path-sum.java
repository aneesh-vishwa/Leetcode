class Pair {
    int row;
    int col;
    int distance;

    Pair(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];

        // Arrays.fill(dist , Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = grid[0][0];

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, grid[0][0]));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int r = pair.row;
            int c = pair.col;
            int current_distance = pair.distance;

            int[] dx = { 0, 1 };
            int[] dy = { 1, 0 };
            for (int i = 0; i < 2; i++) {
                int row = r + dx[i];
                int col = c + dy[i];

                if (row < 0 || row >= m || col < 0 || col >= n) {
                    continue;
                }

                int dist_to_be_added = grid[row][col];

                if (current_distance + dist_to_be_added < dist[row][col]) {
                    dist[row][col] = current_distance + dist_to_be_added;
                    queue.add(new Pair(row, col, dist[row][col]));
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}