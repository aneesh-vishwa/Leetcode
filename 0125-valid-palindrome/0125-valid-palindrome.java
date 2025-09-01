class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        s = s.toLowerCase();

        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; i++){
            if(Character.isLetterOrDigit(arr[i])){
                sb.append(arr[i]);
            }
        }

        String str = sb.toString();

        int m = str.length();
        int left = 0;
        int right = m - 1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
       
        return true;
    }
}