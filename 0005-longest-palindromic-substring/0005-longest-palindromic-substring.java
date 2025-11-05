class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        char[] arr = s.toCharArray();
        int longest_length_odd = 0;
        int longest_length_even = 0;
        String sub_odd = "";
        String sub_even  = "";

        // odd plaindrome
        for (int i = 0; i < n; i++) {
            int left = i, right = i;
            while (left >= 0 && right < n) {
                if (arr[left] == arr[right]) {
                    int len = right - left + 1;
                    if (len > longest_length_odd) {
                        longest_length_odd = len;
                        sub_odd = s.substring(left, right + 1);
                    }
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }

        // even plaindrome
        for (int i = 0; i < n - 1; i++) {
            int left = i, right = i + 1;
            while (left >= 0 && right < n) {
                if (arr[left] == arr[right]) {
                    int len = right - left + 1;
                    if (len > longest_length_even) {
                        longest_length_even = len;
                        sub_even = s.substring(left, right + 1);
                    }
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }
        if(sub_even.length() >= sub_odd.length()){
            return sub_even;
        }
        return sub_odd;
    }
}