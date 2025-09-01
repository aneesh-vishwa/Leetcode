class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        int initial_buy = prices[0];
        for(int i = 1 ; i < n ; i++){
            if(initial_buy < prices[i]){
                profit += prices[i] - initial_buy;
            }
            initial_buy = prices[i];
        }
        return profit;
    }
}