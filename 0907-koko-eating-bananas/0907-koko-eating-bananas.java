class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // int max = piles[0];
        // int n = piles.length;
        // int sum = 0;
        // int output = -1;
        // for(int i=1;i<piles.length;i++){
        //     max = Math.max(piles[i],max);
        // }
        // for(int k=1;k<=max;k++){
        //     int sum = 0;
        //     for(int i=0;i<n;i++){
        //         sum += (piles[i] + k - 1) / k;
        //         if(sum > h){
        //             break;
        //         }
        //     }
        //     if(sum <= h){
        //         output = k;
        //         return output;
        //     }
        // }
        // return output;

        // optimal solution
        int n = piles.length;
        int ans = 0;
        int max = -1;
        int k = 0;
        for(int i=0;i<piles.length;i++){
            max = Math.max(piles[i],max);
        }
        int low = 1;
        int high = max;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            int sum = 0;
            for(int i=0;i<n;i++){
                sum += ((double)(piles[i]) + (double)(mid) - 1)/(double)(mid);
            }
            if(sum <= h){
                k = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return k;
    }
}