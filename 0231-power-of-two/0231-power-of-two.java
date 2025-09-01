class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        int check = n & (n-1);
        if(check == 0){
            return true;
        }
        return false;
    }
}