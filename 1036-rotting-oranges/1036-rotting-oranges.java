class Pair {
    int row;
    int column;
    int time;

    Pair(int row, int column, int time) {
        this.row = row;
        this.column = column;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited_matrix = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Pair(i, j, 0));
                    visited_matrix[i][j] = 1;
                }
                else{
                    visited_matrix[i][j] = 0;
                }
                // if(grid[i][j] == 1){
                //     count+=
                // }

            }
        }
        int time = 0;
        int[] row = {-1, 0, 1, 0};
        int[] column = {0, 1, 0, -1};
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int r = pair.row;
            int c = pair.column;
            int t = pair.time;
            for(int i = 0 ; i < 4 ; i++){
                int neighbour_row = r + row[i];
                int neighbour_column = c + column[i];
                if (neighbour_row < 0 || neighbour_column < 0 || neighbour_row >= n || neighbour_column >= m || grid[neighbour_row][neighbour_column] == 0 || visited_matrix[neighbour_row][neighbour_column] == 1){  
                    continue;
                }
                queue.offer(new Pair(neighbour_row, neighbour_column,t+1));
                visited_matrix[neighbour_row][neighbour_column] = 1;
                time = Math.max(time, t + 1);
            }

        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(visited_matrix[i][j] == 0 && grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;
    }
}