class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int  n = bits.length;
        int i = 0;

        while(i < n - 1){
            if(bits[i] == 0){
                i++;
            }
            else{
                i += 2;
            }
        }
        if(i == n){
            return false;
        }
        return true;
    }
}