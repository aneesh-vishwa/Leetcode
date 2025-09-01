class Solution {
    public String reverseWords(String s) {
        String str = "";
        s = s.trim().replaceAll("\\s+", " ");;
        String[] words = s.split(" ");
        int n = words.length;
        for(int i = n-1;i>=0;i--){
            str += words[i];
            if (i != 0) { 
                str += " ";
            }
        }
        return str;
    }
}