class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()){
            return -1;
        }
        for(int i = 0 ; i < haystack.length() - needle.length() + 1 ; i++){
            int left = i;
            int right = i + needle.length();
            if(haystack.substring(left , right).equals(needle)){
                return i;
            }

        }
        return -1;
    }
}