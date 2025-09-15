class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }
        // String[] words = text.split(" ");
        // int n = words.length;
        int count = 0;
        int n = text.length();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);

            if (ch == ' ') {
                if (!flag) {
                    count++;
                }
                flag = false;
            }
            else if (set.contains(ch)) {
                flag = true;
            }
        }
        if (!flag) {
            count++;
        }
        return count;
    }
}