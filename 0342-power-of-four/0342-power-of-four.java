class Solution {
    public boolean isPowerOfFour(int n) {
        //power of 4 is always a power of 2
        if (n <= 0) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}