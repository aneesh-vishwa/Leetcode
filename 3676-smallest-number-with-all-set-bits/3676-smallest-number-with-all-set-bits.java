class Solution {
    public int smallestNumber(int n) {
        if(n == 1){
            return 1;
        }
        // if()
        int temp = n;
        int two_pow = 1;
        while(two_pow <= temp){
            two_pow *= 2;

        }
        return two_pow - 1;
    }
}