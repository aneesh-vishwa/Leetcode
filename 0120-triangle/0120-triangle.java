class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] dp = new int[rows];

        for(int i = rows - 1 ; i >= 0 ; i--){
            dp[i] = triangle.get(rows - 1).get(i);
        }

        for(int row = rows - 2 ; row >= 0 ; row--){
            for(int col = 0 ; col <= row ; col++){
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col] , dp[col + 1]);
            }
        }
        return dp[0];




        // int index = 0;
        // int n = triangle.size();
        // if(n == 1){
        //     return triangle.get(0).get(0);
        // }
        // int sum = 0;
        // sum += triangle.get(0).get(0);

        // for(int i = 1 ; i < n ; i++){
        //     int first = triangle.get(i).get(index);
        //     int second = triangle.get(i).get(index + 1);
        //     if(first < second){
        //         sum += first;
        //         index = index;
        //     }
        //     else{
        //         sum += second;
        //         index = index + 1;
        //     }
        // }
        // return sum;
    }
}