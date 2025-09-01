class Solution {
    public int dfs(int row, int col, int[][] matrix, int[][] LIP) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] d_row = { 1, 0, -1, 0 };
        int[] d_col = { 0, 1, 0, -1 };

        if (LIP[row][col] != 0)
            return LIP[row][col];

        int maxPath = 1;

        for (int i = 0; i < 4; i++) {
            int r = row + d_row[i];
            int c = col + d_col[i];

            if (r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] > matrix[row][col]) {
                maxPath = Math.max(maxPath, 1 + dfs(r, c, matrix,LIP));
            }
        }

        LIP[row][col] = maxPath;
        return maxPath;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxlen = 1;
        int[][] LIP = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                maxlen = Math.max(maxlen, dfs(i , j , matrix , LIP));
            }
        }
        return maxlen;
    }
}