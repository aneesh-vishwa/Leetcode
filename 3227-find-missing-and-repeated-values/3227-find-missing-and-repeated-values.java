class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] output = new int[2];
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        int repeated = -1;
        int original_sum = ((m*n) * (m*n + 1))/2;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                sum += grid[i][j];
                if(set.contains(grid[i][j])){
                    repeated = grid[i][j];
                }
                set.add(grid[i][j]);
            }
        }
        int missing = original_sum - (sum - repeated);
        output[0] = repeated;
        output[1] = missing;
        return output;
    }
}