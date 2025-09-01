class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] grid = new int[m][n];

        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) return 0;

          // Initialize last row from right to left, stop at obstacle
        for (int k = n - 1; k >= 0; k--) {
            if (obstacleGrid[m - 1][k] == 1) break;
            grid[m - 1][k] = 1;
        }

        // Initialize last column from bottom to top, stop at obstacle
        for (int l = m - 1; l >= 0; l--) {
            if (obstacleGrid[l][n - 1] == 1) break;
            grid[l][n - 1] = 1;
        }

        // for(int a = 0 ; a < m ; a++){
        //     for(int b = 0 ; b < n ; b++){
        //         if(obstacleGrid[a][b] == 1){
        //             grid[a][b] = 0;
        //         }
        //     }
        // }
        for(int i = m - 2 ; i >= 0 ; i--){
            for(int j = n - 2 ; j >= 0 ; j--){
                if(obstacleGrid[i][j] != 1){
                    grid[i][j] = grid[i+1][j] + grid[i][j+1];
                }  
            }
        }
        return grid[0][0];
    }
}



// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         int[][] grid = new int[m][n];

//         if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) return 0;

//         // Initialize last row from right to left, stop at obstacle
//         for (int k = n - 1; k >= 0; k--) {
//             if (obstacleGrid[m - 1][k] == 1) break;
//             grid[m - 1][k] = 1;
//         }

//         // Initialize last column from bottom to top, stop at obstacle
//         for (int l = m - 1; l >= 0; l--) {
//             if (obstacleGrid[l][n - 1] == 1) break;
//             grid[l][n - 1] = 1;
//         }

//         // Fill DP table from bottom-right to top-left
//         for (int i = m - 2; i >= 0; i--) {
//             for (int j = n - 2; j >= 0; j--) {
//                 if (obstacleGrid[i][j] != 1) {
//                     grid[i][j] = grid[i + 1][j] + grid[i][j + 1];
//                 }
//             }
//         }

//         return grid[0][0];
//     }
// }
