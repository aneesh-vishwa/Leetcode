class Solution {
    public boolean anagrams(String a , String b){
        int[] a_freq = new int[26];
        int[] b_freq = new int[26];
        if(a.length() != b.length()){
            return false;
        }
        for(int i = 0 ; i < a.length() ; i++){
            a_freq[a.charAt(i) - 'a']++;
            b_freq[b.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(a_freq[i] != b_freq[i]){
                return false;
            }
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> list = new ArrayList<>();
        String check = words[0];
        for(int i = 1 ; i < n ; i++){
            if(anagrams(check , words[i])){
                continue;
            }
            else{
                list.add(check);
                check = words[i];
            }
        }
        list.add(check);
        return list;
    }
}