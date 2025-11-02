class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] matrix = new int[m][n];
        int no_of_walls = walls.length;
        int no_of_guards = guards.length;
        //walls = -1;
        //guards = 1;

        for (int i = 0; i < no_of_walls; i++) {
            int row = walls[i][0];
            int col = walls[i][1];
            matrix[row][col] = -1;
        }

        for (int i = 0; i < no_of_guards; i++) {
            int row = guards[i][0];
            int col = guards[i][1];
            matrix[row][col] = 1;
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int[] guard : guards) {
            int r = guard[0];
            int c = guard[1];

            for (int dir = 0; dir < 4; dir++) {
                int new_r = r + dx[dir];
                int new_c = c + dy[dir];

                while (new_r >= 0 && new_r < m && new_c >= 0 && new_c < n) {
                    if (matrix[new_r][new_c] == -1 || matrix[new_r][new_c] == 1) {
                        break;
                    }
                    if (matrix[new_r][new_c] == 0) {
                        matrix[new_r][new_c] = 2;
                    }
                    new_r += dx[dir];
                    new_c += dy[dir];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
