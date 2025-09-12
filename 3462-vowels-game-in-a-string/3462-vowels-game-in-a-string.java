class Solution {
    public boolean doesAliceWin(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int vowels = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                vowels++;
            }
        }
        if(vowels == 0){
            return false;
        }
        
        return true;
    }
}