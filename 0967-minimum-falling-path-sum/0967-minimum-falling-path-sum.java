class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];

        for(int i = 0 ; i < n ; i++){
            dp[i] = matrix[n - 1][i];
        }

        for(int row = n - 2 ; row >= 0 ; row--){
            int[] temp = new int[n];
            for(int col = 0 ; col < n ; col++){
                int left = col - 1;
                int middle = dp[col];
                int right = col + 1;
                if(left < 0){
                    left = Integer.MAX_VALUE;
                }
                else{
                    left = dp[left];
                }
                if(right >= n){
                    right = Integer.MAX_VALUE;
                }
                else{
                    right = dp[right];
                }
                temp[col] = matrix[row][col] + Math.min(middle , Math.min(left , right));
            }
            dp = temp;
        }
        int minimum = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            minimum = Math.min(minimum , dp[i]);
        }
        return minimum;
    }
}