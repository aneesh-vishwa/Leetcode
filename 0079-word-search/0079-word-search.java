class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];

        boolean result = false;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == word.charAt(0)){
                    result = backtrack(board , word , visited , i , j , 0);
                    if(result){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, String word , int[][] visited , int row , int col , int index){
        int k = word.length();
        if(index == k){
            return true;
        }
        
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index) || visited[row][col] == 1){
            return false;
        }
        char current = board[row][col];
        visited[row][col] = 1;

        int[] dx = {0 , -1 , 0 , 1};
        int[] dy = {1 , 0 , -1 , 0};

        for(int i = 0 ; i < 4 ; i++){
            int r = row + dx[i];
            int c = col + dy[i];

            if(backtrack(board , word , visited , r , c , index + 1)){
                return true;
            }
        }

        visited[row][col] = 0; //if that path cant fiind the ans we back track to previous char by unvisiting the current row, col. 
        return false;


    }
}