class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxlen = 0;
        int maxfreq = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int n = arr.length;
        while(r<n){
           char c = arr[r];

           map.put(c, map.getOrDefault(c,0)+1);

           for(int value : map.values()){
            maxfreq = Math.max(maxfreq, value);
           }

           if(r-l+1 - maxfreq > k){
            map.put(arr[l], map.getOrDefault(arr[l] , 0) -1);
            l++;
           }
           
           if(r-l+1 - maxfreq <= k){
            maxlen = Math.max(maxlen , r-l+1);
           }
           r++;
        }
        return maxlen;
    }
}