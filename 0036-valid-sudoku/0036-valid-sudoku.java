class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> rows = new ArrayList<>();
        List<HashSet<Character>> cols = new ArrayList<>();
        List<HashSet<Character>> boxes = new ArrayList<>();


        for(int i = 0 ; i < 9 ; i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for(int r = 0 ; r < 9 ; r++){
            for(int c = 0 ; c < 9 ; c++){
                if(board[r][c] == '.'){
                    continue;
                }
                char val = board[r][c];
                int box_index = (r / 3) * 3 + (c / 3);

                if(rows.get(r).contains(val) || cols.get(c).contains(val) || boxes.get(box_index).contains(val)){
                    return false;
                }
                rows.get(r).add(val);
                cols.get(c).add(val);
                boxes.get(box_index).add(val);
            }
        }
        return true;
    }
}