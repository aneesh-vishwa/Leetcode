class Solution {
    public String removeDuplicateLetters(String s) {
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        Stack<Character> st = new Stack<>();

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.get(arr[i]) - 1); 

            if (set.contains(arr[i])) {
                continue;
            }

            while (!st.isEmpty() && st.peek() > arr[i] && map.get(st.peek()) > 0) {
                set.remove(st.pop());
            }

            st.push(arr[i]);
            set.add(arr[i]);
        }

        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.reverse().toString();
    }
}
