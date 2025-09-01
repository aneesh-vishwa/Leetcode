class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> gue_map = new HashMap<>();
        HashMap<Character, Integer> sec_map = new HashMap<>();
        char[] sec = secret.toCharArray();
        char[] gue = guess.toCharArray();

        int bulls = 0;
        int cows = 0;

        int n = sec.length;

        for (int i = 0; i < n; i++) {
            if (sec[i] == gue[i]) {
                bulls++;
            } else {
                gue_map.put(gue[i], gue_map.getOrDefault(gue[i], 0) + 1);
                sec_map.put(sec[i], sec_map.getOrDefault(sec[i], 0) + 1);
            }
        }
        for (char ch : gue_map.keySet()) {
            if (sec_map.containsKey(ch)) {
                cows += Math.min(gue_map.get(ch), sec_map.get(ch));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append('A').append(cows).append('B');

        return sb.toString();
    }
}