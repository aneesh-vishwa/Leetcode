class Solution {
    public String largestOddNumber(String num) {
        // traverse the string from the back and return the substring from the start to the odd encountered index

        char[] arr = num.toCharArray();
        int n = arr.length;
        for(int i = n-1 ; i >= 0 ; i--){
            char ch = arr[i];
            // int number = Integer.parseInt(ch);
            int number = ch - '0';
            if(number % 2 != 0){
                String substring = num.substring(0,i+1);
                return substring;
            }

        }
        return "";
    }
}