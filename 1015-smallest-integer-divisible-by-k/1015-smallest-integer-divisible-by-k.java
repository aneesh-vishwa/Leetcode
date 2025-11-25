class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0){
            return -1;
        }
        int current = 0;
        for(int i = 1 ; i <= k ; i++){
            current = (10*current + 1) % k;
            if(current == 0){
                return i;
            }
        }
        return -1;
        
    }
}