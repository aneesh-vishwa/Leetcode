class Solution {
    public int minBitFlips(int start, int goal) {
        int k = start ^ goal;
        int count = 0;
        while(k>0){
            count += k%2;
            k = k>>1;
        } 
        return count;
    }
}