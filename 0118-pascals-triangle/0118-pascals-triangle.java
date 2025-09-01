class Solution {
    public List<Integer> generate_row(int row_no){
        List<Integer> temp = new ArrayList<>();

        int res = 1;
        temp.add(1);
        for(int col = 1 ; col < row_no ; col++){
            res= res*(row_no - col);
            res = res/col;
            temp.add(res);
        }
        return temp;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1 ; i <= numRows ; i++){
            ans.add(generate_row(i));
        }
        return ans;
    }
}

// List<List<Integer>> pascal = new ArrayList<>();
// int start = 1;
// List<Integer> list1 = new ArrayList<>();list1.add(start);pascal.add(list1);for(
// int i = 1;i<numRows;i++){
//         List<Integer> prev = pascal.get(i-1);
//         List<Integer> current = new ArrayList<>();
//         current.add(1);
//         for(int j = 1 ; j < prev.size() ; j++){
//             current.add(prev.get(j-1) + prev.get(j));
//         }
//         current.add(1);
//         pascal.add(current);
//     }
//     return pascal;
// }