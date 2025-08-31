class Solution {
    public int maxProfit(int[] prices) {
        
        // int max_profit = 0;
        int n =prices.length;
        // for(int i=0;i<n-1;i++){
        //     int profit = 0;
        //     for(int j=i+1;j<n;j++){
        //         profit = prices[j] - prices[i];
        //         max_profit = Math.max(profit,max_profit);
        //     }
        // }
        // return max_profit;

        // optimal solution
        int buy = prices[0];
        int profit = 0;
        for(int i=1;i<n;i++){
            profit = Math.max(profit, prices[i] - buy);
            buy = Math.min(buy,prices[i]);
        }
        return profit;
    }
}