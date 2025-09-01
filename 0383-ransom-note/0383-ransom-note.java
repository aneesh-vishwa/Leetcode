class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }
            if(map.get(ch)-1 <= 0){
                map.remove(ch);
            }
            else{
                map.put(ch, map.get(ch) - 1);
            }
            
        }

        return true;
    }
}