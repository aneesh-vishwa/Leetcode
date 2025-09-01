class Solution {
    public List<String> generateParenthesis(int n) {
        //take , not take
        int open = 0;
        int close = 0;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(sb , list , open , close , n);
        return list;
    }
    public void backtrack(StringBuilder sb , List<String> list , int open , int close , int n){
        if(sb.length() == 2*n){
            list.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            backtrack(sb , list ,  open + 1 , close , n);
            sb.deleteCharAt(sb.length() - 1);
        }
        // sb.deleteCharAt(sb.length() - 1);
        if(close < open && close < n){
            sb.append(')');
            // close++;
            backtrack(sb , list , open , close + 1 , n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}