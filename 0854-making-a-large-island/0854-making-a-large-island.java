public class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] visited = new int[n][n];
        HashMap<Integer, Integer> map = new HashMap<>();//island_id , area
        int island_id = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(i, j, island_id, grid);
                    map.put(island_id, area);
                    island_id++;
                }
            }
        }

        int max = 0;

        // Step 2: Try flipping each 0 to 1 and calculate total area

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int total = 1;
                    HashSet<Integer> neighborIslands = new HashSet<>();

                    int[] dx = { 0, -1, 0, 1 };
                    int[] dy = { 1, 0, -1, 0 };

                    for (int k = 0; k < 4; k++) {
                        int r = i + dx[k];
                        int c = j + dy[k];

                        if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] > 1) {
                            neighborIslands.add(grid[r][c]);
                        }
                    }
                    for (int id : neighborIslands) {
                        total += map.get(id);
                    }
                    max = Math.max(max, total);
                }
            }
        }
        if (max == 0) {
            return n * n;
        }

        return max;
    }

    public int bfs(int i, int j, int island_id, int[][] grid) {
        int n = grid.length;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        int area = 1;
        grid[i][j] = island_id;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.row;
            int col = pair.col;
            int[] dx = { 0, -1, 0, 1 };
            int[] dy = { 1, 0, -1, 0 };

            for (int k = 0; k < 4; k++) {
                int r = row + dx[k];
                int c = col + dy[k];

                if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 1) {
                    grid[r][c] = island_id;
                    queue.add(new Pair(r, c));
                    area++;
                }
            }
        }
        return area;
    }
}