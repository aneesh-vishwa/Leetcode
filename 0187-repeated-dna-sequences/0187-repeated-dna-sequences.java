class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        for(int i = 0 ; i+9 < s.length() ; i++){
            String sub = s.substring(i,i+10);
            if(!set.add(sub)){ // If adding to set fails (i.e., it's already present), then it's a duplicate, so it's added to res
                res.add(sub);
            }
        }
        return new ArrayList(res);
    }
}