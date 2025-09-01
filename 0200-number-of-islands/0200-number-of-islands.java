class Pair {
    int row;
    int col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int no_of_island = 0;

        int[][] visited = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // BFS
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    no_of_island++;
                    queue.add(new Pair(i, j));
                    visited[i][j] = 1;

                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        int row = pair.row;
                        int col = pair.col;

                        int[] dx = {0, -1, 0, 1};
                        int[] dy = {1, 0, -1, 0};

                        for (int k = 0; k < 4; k++) {
                            int newRow = row + dx[k];
                            int newCol = col + dy[k];

                            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                                grid[newRow][newCol] == '1' && visited[newRow][newCol] == 0) {
                                queue.add(new Pair(newRow, newCol));
                                visited[newRow][newCol] = 1;
                            }
                        }
                    }
                }
            }
        }

        return no_of_island;
    }
}
