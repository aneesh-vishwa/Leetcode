class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int area = findsmallrect(0, 0, n, m, grid);
        return area;
    }

    public int findsmallrect(int strat_row, int start_col, int row_len, int col_len, int[][] grid) {
        boolean has_one_col_first = true;
        boolean has_one_col_last = true;
        boolean has_one_row_first = true;
        boolean has_one_row_last = true;

        for (int j = start_col; j < start_col + col_len; j++) {
            if (grid[strat_row][j] == 1) {
                has_one_row_first = false;
                break;
            }
        }

        for (int j = start_col; j < start_col + col_len; j++) {
            if (grid[strat_row + row_len - 1][j] == 1) {
                has_one_row_last = false;
                break;
            }
        }

        for (int i = strat_row; i < strat_row + row_len; i++) {
            if (grid[i][start_col] == 1) {
                has_one_col_first = false;
                break;
            }
        }

        for (int i = strat_row; i < strat_row + row_len; i++) {
            if (grid[i][start_col + col_len - 1] == 1) {
                has_one_col_last = false;
                break;
            }
        }

        if (has_one_row_first && row_len > 1) {
            return findsmallrect(strat_row + 1, start_col, row_len - 1, col_len, grid);
        }
        if (has_one_row_last && row_len > 1) {
            return findsmallrect(strat_row, start_col, row_len - 1, col_len, grid);
        }
        if (has_one_col_first && col_len > 1) {
            return findsmallrect(strat_row, start_col + 1, row_len, col_len - 1, grid);
        }
        if (has_one_col_last && col_len > 1) {
            return findsmallrect(strat_row, start_col, row_len, col_len - 1, grid);
        }

        return row_len * col_len;
    }
}
