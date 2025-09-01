class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j <= n ; j++){
                String sub = s.substring(i, j);
                if(sub.equals(new StringBuilder(sub).reverse().toString())){
                    count++;
                }
            }
        }
        return count;
    }
}