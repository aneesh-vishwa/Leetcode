class Solution {
    public int maxDifference(String s) {
        int n = s.length();
        HashMap<Character , Integer> map = new HashMap<>();

        char[] arr = s.toCharArray();

        for(int i = 0 ; i < n ; i++){
            char ch = arr[i];
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }
        int odd_freq = Integer.MIN_VALUE;
        int even_freq = Integer.MAX_VALUE;
        for(int value : map.values()){
            if(value%2 == 0){
                even_freq = Math.min(even_freq , value);
            }
            else{
                odd_freq = Math.max(odd_freq , value);
            }
        }
        return odd_freq - even_freq;
    }
}