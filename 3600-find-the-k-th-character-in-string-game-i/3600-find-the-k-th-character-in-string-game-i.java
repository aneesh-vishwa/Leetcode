class Solution {
    public char kthCharacter(int k) {
        int string_len = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        while(string_len < k){
            for(int i = 0 ; i < string_len ; i++){
                char current_char = sb.charAt(i);
                char next_char = (char) ('a' + (current_char - 'a' + 1) % 26);
                sb.append(next_char);
            }
            string_len *= 2;
        }
        return sb.charAt(k - 1);
    }
}