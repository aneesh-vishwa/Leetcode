class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1){
            return nums[0];
        }

        int[] dp1 = new int[n];
        Arrays.fill(dp1 , -1);

        int max1 = helper(0 , n - 2 , nums , dp1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2 , -1);

        int max2 = helper(1 , n - 1 , nums , dp2);

        return Math.max(max1 , max2);
    }

    public int helper(int start , int index , int[] nums , int[] dp){
        if(index < start){
            return 0;
        }
        if(index == start){
            return nums[index];
        }
        if(dp[index] != -1){
            return dp[index];
        }

        int pick = nums[index] + helper(start , index - 2 , nums , dp);

        int not_pick = 0 + helper(start , index - 1 , nums , dp);

        return dp[index] = Math.max(pick , not_pick);
    }
}