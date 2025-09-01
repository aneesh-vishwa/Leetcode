class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length;
        ArrayList<String> out = new ArrayList<>();
        if(n == 1){
            out.add(words[0]);
            return out;
        }

        for(int i = 0 ; i < n-1 ; i++){
            if(groups[i] != groups[i+1]){
                out.add(words[i]);
            }
        }
        out.add(words[n-1]);
        return out;
    }
}