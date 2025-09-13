class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        char[] arr = s.toCharArray();
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            freq[arr[i] - 'a']++;
        }
        int vowels = 0;
        int consonants = 0;

        for(int i = 0 ; i < 26 ; i++){
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20){
                vowels = Math.max(vowels , freq[i]);
            }
            else{
                consonants = Math.max(consonants , freq[i]);
            }
            
        }
        return vowels + consonants;
    }
}