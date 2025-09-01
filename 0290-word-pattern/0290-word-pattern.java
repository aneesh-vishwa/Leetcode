class Solution {
    public boolean wordPattern(String pattern, String s) {
         String[] words = s.split(" ");
         

         HashMap<Character,String> map = new HashMap<>();
         char[] arr = pattern.toCharArray();
         int n = arr.length;
         if (n != words.length){
            return false;
         }
         for(int i = 0 ; i < n ; i++){
           if (map.containsKey(arr[i])) {
                if (!(map.get(arr[i]).equals(words[i]))) {
                    return false;
                }
            }
            else if (map.containsValue(words[i])) {
                return false;
            }
            map.put(arr[i], words[i]);
            
         }
         return true;
    }
}