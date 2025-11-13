class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        // Left -> Right: ensure at any prefix, we don't have more ')' than '(' + '*'
        int open = 0;
        int close = 0;
        int star = 0;
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c == ')') close++;
            else if (c == '(') open++;
            else star++;

            if (close > open + star) return false; // too many ')' to match
        }

        // Right -> Left: ensure at any suffix, we don't have more '(' than ')' + '*'
        open = 0; close = 0; star = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = arr[i];
            if (c == '(') open++;
            else if (c == ')') close++;
            else star++;

            if (open > close + star) return false; // too many '(' to match
        }

        return true;
    }
}