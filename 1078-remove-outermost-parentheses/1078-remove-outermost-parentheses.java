class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        String ans = "";
        char[] arr = s.toCharArray();
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            char ch = arr[i];
            if(ch == ')'){
                count--;
            }
            if(count != 0){
                ans += ch;
            }
            if(ch == '('){
                count++;
            }
        }
        return ans;
    }
}