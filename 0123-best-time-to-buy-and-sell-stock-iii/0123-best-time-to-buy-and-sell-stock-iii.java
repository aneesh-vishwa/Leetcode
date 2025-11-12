class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;


        int max_profit_after_buy_1 = -prices[0];
        int max_profit_after_sell_1 = 0;

        int max_profit_after_buy_2 = -prices[0];
        int max_profit_after_sell_2 = 0;

        for(int i = 1 ; i < n ; i++){
            int price = prices[i];

            //to find the lest price to buy on day 1; max() becaause we are taking price as neg
            max_profit_after_buy_1 = Math.max(max_profit_after_buy_1 , -price);
            //if we are selling on a particular day the profit is the cost price i.e max_profit_after_buy_1 and the price of that stock on that day(price);
            max_profit_after_sell_1 = Math.max(max_profit_after_sell_1 , max_profit_after_buy_1 + price);

            max_profit_after_buy_2 = Math.max(max_profit_after_buy_2 , max_profit_after_sell_1 - price);

            max_profit_after_sell_2 = Math.max(max_profit_after_sell_2 , max_profit_after_buy_2 + price);

        }
        return max_profit_after_sell_2;
    }
}