class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0 ; i < m ; i++){
            Arrays.sort(grid[i]);
        }
        int sum = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            int largest = 0;
            for(int j = 0 ; j < m ; j++){
                largest = Math.max(largest , grid[j][i]);
            }
            sum += largest;
        }
        return sum;
    }
}