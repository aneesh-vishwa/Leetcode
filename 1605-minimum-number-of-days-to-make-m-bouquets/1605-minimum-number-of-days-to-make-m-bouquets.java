class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // /*the thing is after how many minimum no of days we will be 
        // able to get the required no of bouquets*/
        // int n = bloomDay.length;
        // int output = 0;
        // if(m*k > n){ //if we need more flowers than we have we cant make the required no of boquets.
        //     return -1;
        // }
        //  int min = Integer.MAX_VALUE; 
        // int max = 0; 

        // for (int i = 0; i < n; i++) {
        //     min = Math.min(min, bloomDay[i]);
        //     max = Math.max(max, bloomDay[i]);
        // }

        // for(int i = min;i <= max;i++){
        //     int counter = 0;
        //     int no_of_boquets = 0;
        //     for(int j = 0;j < n;j++){
        //         if(bloomDay[j] <= i){
        //             counter++;
        //         }
        //         else{
        //             no_of_boquets += counter/k;
        //             counter = 0;
        //         }
        //     }
        //     no_of_boquets += counter / k; //?
        //     if(no_of_boquets >= m){
        //         output = i;
        //         break;
                
        //     }
        // }
        // return output;

        // optimal approach

        int n = bloomDay.length;
        int output = 0;
        if((long)(m*k) > (long)n){ //if we need more flowers than we have we cant make the required no of boquets.
            return -1;
        }
        int min = Integer.MAX_VALUE; 
        int max = 0; 

        for (int i = 0; i < n; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        int low = min;
        int high = max;
        int ans = -1;
        while(low <= high){//we are going from min to max 
            int mid = low + (high - low)/2;
            int counter = 0;
            int no_of_bouquets = 0;
            for(int i=0;i<n;i++){
                
                if(bloomDay[i] <= mid){
                    counter++;
                }
                else{
                    no_of_bouquets += counter/k;
                    counter = 0;
                }
                
            }
            no_of_bouquets += counter/k;
            if(no_of_bouquets >= m){
                high = mid - 1;
                ans = mid;
            }
            else{
                low = mid + 1;
            }

        }
        return ans;
    }
}