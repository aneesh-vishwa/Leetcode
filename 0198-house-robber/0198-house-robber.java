class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);

        return helper(n - 1 , nums , dp);

        // return dp[n - 1];
    }
    public static int helper(int index , int[] nums , int[] dp){
        if(index == 0){
            return nums[0];
        }
        if(index < 0){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int pick = nums[index] + helper(index - 2 , nums , dp);

        int not_pick = 0 + helper(index - 1 , nums , dp);

        return dp[index] = Math.max(pick , not_pick);
    }
}