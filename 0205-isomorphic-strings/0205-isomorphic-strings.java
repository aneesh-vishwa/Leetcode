class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        // HashSet<Character> set_s = new HashSet<>();
        // HashSet<Character> set_t = new HashSet<>();
        
        // char[] string_s = s.toCharArray();
        // char[] string_t = t.toCharArray();
        // for(int i = 0 ; i < s.length() ; i++){
        //     char ch_s = string_s[i];
        //     char ch_t = string_t[i];
        //     set_s.add(ch_s);
        //     set_t.add(ch_t);
        // }

        // if(set_s.size() == set_t.size()){
        //     return true;
        // }
        // return false;

         HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch_s = s.charAt(i);
            char ch_t = t.charAt(i);

            // Check if mapping in s → t is consistent
            if (mapST.containsKey(ch_s) && mapST.get(ch_s) != ch_t) {
                return false;
            }

            // Check if mapping in t → s is consistent
            if (mapTS.containsKey(ch_t) && mapTS.get(ch_t) != ch_s) {
                return false;
            }

            // Create the mapping
            mapST.put(ch_s, ch_t);
            mapTS.put(ch_t, ch_s);
        }

        return true;
        
    }
}