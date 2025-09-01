class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length ; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }

        boolean has_odd = false;
        // Collection<Integer> values = map.values();
        int count = 0;
        for(int val : map.values()){
            if(val%2 == 0){
                count += val;
            }
            else{
                count += val - 1;
                has_odd = true;
            }
        }
        if(has_odd){
            count += 1;
        }

        return count;
    }
}