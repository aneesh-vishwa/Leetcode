class Solution {
    public String longestCommonPrefix(String[] strs) {
        // String ans = "";
        int n = strs.length;
        int k = Integer.MAX_VALUE;
        for(String s : strs){
            k = Math.min(k , s.length());
        }
       StringBuilder ans = new StringBuilder();
        
        // Check character by character for common prefix
        for (int i = 0; i < k; i++) {
            char ch = strs[0].charAt(i); // Take character from the first string

            // Check if all other strings have the same character at index i
            for (String s : strs) {
                if (s.charAt(i) != ch) {
                    return ans.toString(); // Stop if mismatch found
                }
            }
            ans.append(ch); // Append common character
        }
        return ans.toString();
    }
}




// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs == null || strs.length == 0) return "";
//     String prefix = strs[0];
//     for (int i = 1; i < strs.length; i++) {
//         while (strs[i].indexOf(prefix) != 0) {
//             prefix = prefix.substring(0, prefix.length() - 1);
//             if (prefix.isEmpty()) return "";
//         }
//     }
//     return prefix;
//     }
// }