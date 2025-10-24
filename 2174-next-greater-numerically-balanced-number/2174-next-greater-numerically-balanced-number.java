class Solution {
    public int nextBeautifulNumber(int n) {
        int i = n + 1;
        for(i = n + 1 ; i < Integer.MAX_VALUE ; i++){
            int[] count = new int[10];
            int num = i;
            while(num > 0){
                count[num % 10]++;
                num = num/10;
            }
            boolean is_balanced = true;
            for(int j = 0 ; j < 10 ; j++){
                if(count[j] > 0 && count[j] != j){
                    is_balanced = false;
                    break;
                }
            }
            if(is_balanced){
                return i;
            }
        }
        return -1;
    }
}