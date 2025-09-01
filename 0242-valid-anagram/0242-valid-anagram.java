class Solution {
    public boolean isAnagram(String s, String t) {
        char[] char_s= s.toCharArray();
        char[] char_t = t.toCharArray();
        Arrays.sort(char_s);
        Arrays.sort(char_t);
        s = new String(char_s);
        t = new String(char_t);
        if(s.equals(t)){
            return true;
        }
        return false;
    }
}