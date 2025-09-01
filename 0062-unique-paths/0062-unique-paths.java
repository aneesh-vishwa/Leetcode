class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for(int k = 0 ; k < n ; k++){
            grid[m-1][k] = 1;
        }
        for(int l = 0 ; l < m ; l++){
            grid[l][n-1] = 1;
        }
        for(int i = m - 2 ; i >= 0 ; i--){
            for(int j = n - 2 ; j >= 0 ; j--){
                grid[i][j] = grid[i+1][j] + grid[i][j+1];
            }
        }
        return grid[0][0];
    }
}