class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        long left = 0;
        long right = x;
        
        long out = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long res = mid * mid;
            if (res < x) {
                out = mid;
                left = mid + 1;
            } 
            else if(res == x){
                return (int)mid;
            }
            else {
                right = mid - 1;
            }
        }

        return (int)out;









    }
}