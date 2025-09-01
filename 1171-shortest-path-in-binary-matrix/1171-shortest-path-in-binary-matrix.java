class Pair {
    int row;
    int column;
    int length;

    Pair(int row, int column, int length) {
        this.row = row;
        this.column = column;
        this.length = length;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] visited_matrix = new int[n][n];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, 1));
        visited_matrix[0][0] = 1;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        if( n == 1 && grid[n-1][n-1] == 0){
            return 1;
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.peek();
            queue.remove();
            int row = pair.row;
            int column = pair.column;
            int length = pair.length;
            int[] d_row = { -1, 0, 1, 0, -1, 1, 1, -1 };
            int[] d_col = { 0, 1, 0, -1, 1, 1, -1, -1 };
            for (int i = 0; i < 8; i++) {
                int r = row + d_row[i];
                int c = column + d_col[i];
                if (r < 0 || r >= n || c < 0 || c >= n || visited_matrix[r][c] == 1 || grid[r][c] == 1) {
                    continue;
                }
                
                if (r == n - 1 && c == n - 1) {
                    return length + 1;
                }
                queue.add(new Pair(r, c, length + 1));
                visited_matrix[r][c] = 1;
            }
        }

        return -1;
    }
}