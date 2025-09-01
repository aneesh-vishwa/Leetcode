class Pair {
    int row;
    int column;
    int distance;

    Pair(int row, int column, int distance) {
        this.row = row;
        this.column = column;
        this.distance = distance;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] output = new int[n][m];
        int[][] visited_matrix = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Pair(i, j, 0));
                    visited_matrix[i][j] = 1;
                    output[i][j] = 0;
                }
            }
        }
        int[] d_row = { -1, 0, 1, 0 };
        int[] d_col = { 0, 1, 0, -1 };
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.row;
            int column = pair.column;
            int distance = pair.distance;
            for (int k = 0; k < 4; k++) {
                int neighbour_row = row + d_row[k];
                int neighbour_column = column + d_col[k];
                if (neighbour_row < 0 || neighbour_column < 0 || neighbour_row >= n || neighbour_column >= m
                        || visited_matrix[neighbour_row][neighbour_column] == 1) {
                    continue;
                }
                queue.add(new Pair(neighbour_row, neighbour_column, distance + 1));
                output[neighbour_row][neighbour_column] = distance + 1;
                visited_matrix[neighbour_row][neighbour_column] = 1;
            }
        }
        return output;
    }
}