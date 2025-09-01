class Pair{
    int row;
    int col;
    Pair(int row , int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    queue.offer(new Pair(i,j));
                }
            }
        }

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int row = pair.row;
            int col = pair.col;
            int remove = 0;

            int[] dx = {0,1,0,-1};
            int[] dy = {1,0,-1,0};

            for(int i = 0 ; i < 4 ; i++){
                int new_r = row + dx[i];
                int new_c = col + dy[i];

                if(new_r < 0 || new_r >= m || new_c < 0 || new_c >= n){
                    continue;
                }

                if(grid[new_r][new_c] == 1){
                    remove++;
                }
            }
            count += (4 - remove);
        }

        return count;
    }
}