class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = 0;
        int max = 0;
        int ans = -1;
        for(int i=0;i<n;i++){
            low = Math.max(low,weights[i]);
            // max = Math.max(max,weights[i]);
            max += weights[i];
        }
        int high = max;
        while(low <= high){
            int mid = (low + high)/2;
            int sum = 0;
            int day = 1;
            for(int i=0;i<n;i++){
               if (sum + weights[i] > mid) { /*sum ki add chesena weight mid kanna ekkuva undakudadhu
                oka vela ekkuiva avthe ah weight ni next day ki add cheyyali so day++ 
                and next day starts with weight[i](ekkuva aina weight) */
                    day++;
                    sum = weights[i];
                } else {
                    sum += weights[i];// sum <= mid aithe inka weight add cheyyachu
                }
            }
            if(day <= days){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}