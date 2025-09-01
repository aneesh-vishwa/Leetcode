class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        char[] arr_s = stones.toCharArray();
        char[] arr_j = jewels.toCharArray();
        int sum = 0;

        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr_s.length ; i++){
            map.put(arr_s[i] , map.getOrDefault(arr_s[i] , 0) + 1);
        }
        for(int j = 0 ; j < arr_j.length ; j++){
            if(map.containsKey(arr_j[j])){
                sum += map.get(arr_j[j]);
            }
        }
        return sum;
    }
}