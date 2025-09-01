class Solution {
    public void dfs(int row , int column , int initial_color, int color, int[] check_row, int[] check_col, int[][] image){
        image[row][column] = color;
        int m = image.length;
        int n = image[0].length;
        for(int i = 0 ; i < 4 ; i++){
            int r = row + check_row[i];
            int c = column + check_col[i];
            if(r < m && r >= 0 && c < n && c>= 0 && image[r][c] == initial_color){
                
                dfs(r,c,initial_color,color,check_row,check_col,image);
            }
           
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int initial_color = image[sr][sc];
        // if (initial_color == color) return image;
        int[] check_row = {1,0,-1,0};
        int[] check_col = {0,1,0,-1};
        if(initial_color != color){
            dfs(sr,sc,initial_color,color,check_row,check_col,image);
        }
        

        return image;
    }
}