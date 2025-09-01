class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int[][] output = new int[n][n];

        for(int l = 0 ; l < n ; l++){
            ArrayList<Integer> list = new ArrayList<>();
            int i = l;
            int j = 0;
            int out_i = i;
            int out_j = j;
            // list.add(grid[i][j]);
            while(i < n && j < n){
                list.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(list , Collections.reverseOrder());
            int k = 0;
            while(!list.isEmpty() && out_i < n && out_j < n){
                output[out_i][out_j] = list.get(k);
                k++;
                out_i++;
                out_j++;
            }
        }
        
        for(int l = 1 ; l < n ; l++){
            int i = 0;
            int j = l;
            int out_i = i;
            int out_j = j;
            ArrayList<Integer> list = new ArrayList<>();
            while(i < n && j < n){
                list.add(grid[i][j]);
                i++;
                j++;
            }

            Collections.sort(list);
            int k = 0;

            while(!list.isEmpty() && out_i < n && out_j < n){
                output[out_i][out_j] = list.get(k);
                k++;
                out_i++;
                out_j++;
            }
        }
        return output;
    }
}