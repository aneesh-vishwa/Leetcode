class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;
        for (int current_amount = 1; current_amount <= amount; current_amount++) {
            for (int i = 0; i < n; i++) {
                if (coins[i] <= current_amount && dp[current_amount - coins[i]] != Integer.MAX_VALUE) {
                    dp[current_amount] = Math.min(dp[current_amount], 1 + dp[current_amount - coins[i]]);
                }
            }
        }
        // if(dp[amount] == Integer.MAX_VALUE || dp[amount] == Integer.MIN_VALUE){
        //     return -1;
        // }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } 
        else {
            return dp[amount];
        }
        
    }
}