class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> output = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0) return output;

        int wordCount = words.length;
        int wordLength = words[0].length();
        int totalLength = wordCount * wordLength;

        if (s.length() < totalLength) return output;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i;
            int count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (map.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    while (windowMap.get(word) > map.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    if (count == wordCount) {
                        output.add(left);
                    }

                } else {
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return output;
    }
}



// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         List<Integer> output = new ArrayList<>();

//         if (s == null || s.length() == 0 || words == null || words.length == 0)
//             return output;

//         int word_arr_length = words.length;
//         int len_each_word = words[0].length();
//         int total_len = word_arr_length * len_each_word; // window size

//         Map<String, Integer> map = new HashMap<>();

//         for (String word : words) {
//             map.put(word, map.getOrDefault(word, 0) + 1);
//         }

//         for (int i = 0; i <= s.length() - total_len; i++) {
//             Map<String, Integer> seen = new HashMap<>();
//             int j = 0;

//             while (j < word_arr_length) {
//                 int wordIndex = i + j * len_each_word;
//                 String currentWord = s.substring(wordIndex, wordIndex + len_each_word);

//                 if (map.containsKey(currentWord)) {
//                     seen.put(currentWord, seen.getOrDefault(currentWord, 0) + 1);
//                     if (seen.get(currentWord) > map.get(currentWord)) {
//                         break;
//                     }
//                 } else {
//                     break;
//                 }
//                 j++;
//             }

//             if (j == word_arr_length) {
//                 output.add(i);
//             }
//         }

//         return output;
//     }
// }
// TLE
