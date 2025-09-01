class Solution {
    public void dfs(int row, int col, char[][] board, int[][] visited_mat) {
        int m = board.length;
        int n = board[0].length;
        visited_mat[row][col] = 1;
        int[] check_row = { 1, 0, -1, 0 };
        int[] check_col = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int r = row + check_row[i];
            int c = col + check_col[i];
            if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] == 'X' || visited_mat[r][c] == 1) {
                continue;
            }
            dfs(r, c, board, visited_mat);
        }
    }

    public void solve(char[][] board) {
        // check all the boundary 0's and apply dfs and mark them as 1 in visted matrix.
        // now mark all the o's to 1 where visied mat is not marked

        int m = board.length;
        int n = board[0].length;
        int[][] visited_mat = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                visited_mat[i][j] = 0;
            }
        }

        for (int j = 0; j < n; j++) {
            if (visited_mat[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, board, visited_mat);
            }
            if (visited_mat[m - 1][j] == 0 && board[m - 1][j] == 'O') {
                dfs(m - 1, j, board, visited_mat);
            }
        }
        for (int i = 0; i < m; i++) {
            if (visited_mat[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, board, visited_mat);
            }
            if (visited_mat[i][n - 1] == 0 && board[i][n - 1] == 'O') {
                dfs(i, n - 1, board, visited_mat);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited_mat[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}