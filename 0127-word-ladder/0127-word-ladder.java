class Pair {
    String str;
    int steps;

    Pair(String str, int steps) {
        this.str = str;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }
        set.remove(beginWord);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            String current_str = pair.str;
            int current_steps = pair.steps;

            if (current_str.equals(endWord)) {
                return current_steps;
            }

            for (int i = 0; i < current_str.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] arr = current_str.toCharArray();
                    arr[i] = ch;
                    String replaced_str = new String(arr);

                    if(set.contains(replaced_str)){
                        set.remove(replaced_str);
                        queue.add(new Pair(replaced_str , current_steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}