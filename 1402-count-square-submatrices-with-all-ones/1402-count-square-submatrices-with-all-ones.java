class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < n ; i++){//for first row
            dp[0][i] = matrix[0][i];
        }
        for(int i = 0 ; i < m ; i++){//for first col
            dp[i][0] = matrix[i][0];
        }

        for(int i = 0 ; i < m - 1 ; i++){
            for(int j = 0 ; j < n - 1 ; j++){
                if(matrix[i + 1][j + 1] == 1){
                    dp[i + 1][j + 1] = Math.min(dp[i][j] , Math.min(dp[i + 1][j] , dp[i][j + 1])) + 1;
                }
                else{
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        int sum = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                sum += dp[i][j];
            }
        }
        return sum;
    }
}