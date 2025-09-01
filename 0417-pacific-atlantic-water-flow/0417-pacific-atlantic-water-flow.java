class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        List<List<Integer>> output = new ArrayList<>();
        int n = heights[0].length;
        boolean[][] P_visited = new boolean[m][n];
        boolean[][] Q_visited = new boolean[m][n];

        Queue<int[]> P_queue = new LinkedList<>();
        Queue<int[]> Q_queue = new LinkedList<>();


        for(int i = 0 ; i < n ; i++){
            P_visited[0][i] = true;
            P_queue.add(new int[]{0 , i});

            Q_visited[m - 1][i] = true;
            Q_queue.add(new int[] {m - 1 , i});
        }
        for(int i = 0 ; i < m ; i++){
            P_visited[i][0] = true;
            P_queue.add(new int[]{i , 0});

            Q_visited[i][n - 1] = true;
            Q_queue.add(new int[]{i , n - 1});
        }
        int[] dx = {0 , 1 , 0 , -1};
        int[] dy = {1 , 0 , -1 , 0};

        while(!P_queue.isEmpty()){
            int[] pair = P_queue.poll();
            int row = pair[0];
            int col = pair[1];

            for(int i = 0 ; i < 4 ; i++){
                int new_row = row + dx[i];
                int new_col = col + dy[i];

                if(new_row < 0 || new_col < 0 || new_row >= m || new_col >= n || heights[row][col] > heights[new_row][new_col] || P_visited[new_row][new_col] == true){
                    continue;
                }
                P_visited[new_row][new_col] = true;
                P_queue.add(new int[] {new_row , new_col});



                // if(new_row >= m || new_col >= n ){
                //     output.add(Arrays.asList(row, col));
                // }
                
                // if(new_row < m && new_col < n && heights[row][col] <= heights[new_row][new_col]){
                //     queue.add(new int[] {new_row , new_col});
                // }
            }
        }


        while(!Q_queue.isEmpty()){
            int[] pair = Q_queue.poll();
            int row = pair[0];
            int col = pair[1];

            for(int i = 0 ; i < 4 ; i++){
                int new_row = row + dx[i];
                int new_col = col + dy[i];

                if(new_row < 0 || new_col < 0 || new_row >= m || new_col >= n || heights[row][col] > heights[new_row][new_col] || Q_visited[new_row][new_col] == true){
                    continue;
                }
                Q_visited[new_row][new_col] = true;
                Q_queue.add(new int[] {new_row , new_col});
            }
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(P_visited[i][j] && Q_visited[i][j]){
                    output.add(Arrays.asList(i , j));
                }
            }
        }
        return output;
    }
}