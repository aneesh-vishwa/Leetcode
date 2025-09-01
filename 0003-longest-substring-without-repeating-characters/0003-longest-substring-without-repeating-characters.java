class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxlen = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        while(r<n){
            if(map.containsKey(arr[r]) && map.get(arr[r]) >= l){
                l = map.get(arr[r]) + 1;
            }
            map.put(arr[r],r);
            maxlen = Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}