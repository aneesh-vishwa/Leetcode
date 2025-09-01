class Solution {
    public int longestSubstring(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : arr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : map.keySet()) {
            if (map.get(ch) < k) {
                int max_len = 0;
                for (String sub : s.split(String.valueOf(ch))) {
                    // Recursively, let's check the smaller pieces
                    max_len = Math.max(max_len, longestSubstring(sub, k));
                }
                return max_len;
            }
        }
        return s.length();
        
    }
}