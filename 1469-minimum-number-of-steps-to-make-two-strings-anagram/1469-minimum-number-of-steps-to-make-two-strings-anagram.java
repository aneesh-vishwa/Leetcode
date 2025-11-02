class Solution {
    public int minSteps(String s, String t) {
        // HashMap<Character, Integer> map1 = new HashMap<>();
        // HashMap<Character, Integer> map2 = new HashMap<>();
        char[] arr_s = s.toCharArray();
        char[] arr_t = t.toCharArray();
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        int n = arr_s.length;
        for(int i = 0 ; i < n ; i++){
            map1[arr_s[i] - 'a']++;
            map2[arr_t[i] - 'a']++;
            // map1.put(arr_s[i], map1.getOrDefault(arr_s[i] , 0) + 1);
            // map2.put(arr_t[i], map2.getOrDefault(arr_t[i] , 0) + 1);
        }
        int excess = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(map1[i] == map2[i]){
                continue;
            }
            else{
                excess += Math.abs(map1[i] - map2[i]);
            }
        }
        return excess/2;

    }
}