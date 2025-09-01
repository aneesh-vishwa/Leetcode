class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;
        int windowSize = p.length();

        while (end < s.length()) {
            char ch = s.charAt(end);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (end - start + 1 == windowSize) {
                if (window.equals(pMap)) {
                    result.add(start);
                }

                char startChar = s.charAt(start);
                window.put(startChar, window.get(startChar) - 1);
                if (window.get(startChar) == 0) {
                    window.remove(startChar);
                }
                start++;
            }

            end++;
        }

        return result;
    }
}
