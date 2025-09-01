class Solution {
    public boolean isSubsequence(String s, String t) {
        int s_l = s.length();
        int t_l = t.length();

        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();

        int i = 0;
        int j = 0;

        while(i < s_l && j < t_l){
            if(s_arr[i] == t_arr[j]){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        if(i == s_l){
            return true;
        }
        return false;
    }
}