class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int left = 0;
        int right = left + 1;
        int sum = 0;
        while(left != n && right < n){
            if(!bank[left].contains("1")){
                left++;
                right++;
                continue;
            }
            if(!bank[right].contains("1")){
                right++;
                continue;
            }
            else {
                int freq_left = 0;
                int freq_right = 0;
                int m = bank[0].length();
                for(int i = 0 ; i < m ; i++){
                    if(bank[left].charAt(i) == '1'){
                        freq_left++;
                    }
                    if(bank[right].charAt(i) == '1'){
                        freq_right++;
                    }
                }
                sum += freq_left*freq_right;
            }
            left = right;
            right++;
        }
        return sum;
    }
}