class Pair {
    int row;
    int column;

    Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] visited_matrix = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }



        // for(int j = 0 ; j < n ; j++){
        //     if(grid[0][j] == 1 && visited_matrix[0][j] == 0){
        //         count--;
        //         queue.add(new Pair(0,j));
        //         visited_matrix[0][j] = 1;
        //     }
        //     if(grid[m-1][j] == 1 && visited_matrix[m-1][j] == 0){
        //         count--;
        //         visited_matrix[m-1][j] = 1;
        //         queue.add(new Pair(m-1,j));
        //     }
        // }


        // for(int i = 0 ; i < m ; i++){
        //     if(grid[i][0] == 1 && visited_matrix[i][0] == 0){
        //         count--;
        //         visited_matrix[i][0] = 1;
        //         queue.add(new Pair(i,0));
        //     }
        //     if(grid[i][n-1] == 1 && visited_matrix[i][n-1] == 0){
        //         count--;
        //         visited_matrix[i][n-1] = 1;
        //         queue.add(new Pair(i,n-1));
        //     }
        // }

        int[] traverse_row = { 0, m - 1 };
        int[] traverse_col = { 0, n - 1 };

        for (int i : traverse_row) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited_matrix[i][j] == 0) {
                    queue.add(new Pair(i, j));
                    visited_matrix[i][j] = 1;
                    count--;
                }
            }
        }

        for (int j : traverse_col) { 
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1 && visited_matrix[i][j] == 0) {
                    queue.add(new Pair(i, j)); 
                    visited_matrix[i][j] = 1;
                    count--;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.row;
            int column = pair.column;
            int[] d_row = { 1, 0, -1, 0 };
            int[] d_col = { 0, 1, 0, -1 };
            for (int i = 0; i < 4; i++) {
                int next_row = row + d_row[i];
                int next_col = column + d_col[i];
                if (next_row >= 0 && next_row < m && next_col >= 0 && next_col < n && grid[next_row][next_col] == 1
                        && visited_matrix[next_row][next_col] ==0) {
                    count--;
                    visited_matrix[next_row][next_col] = 1;
                    queue.add(new Pair(next_row, next_col));
                }
            }
        }
        return count;
    }
}