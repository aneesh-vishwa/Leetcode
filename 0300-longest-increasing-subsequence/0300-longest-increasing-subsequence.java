class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1 ; i < n ; i++){
            for(int check = i - 1 ; check >= 0 ; check--){
                if(nums[i] > nums[check]){
                    dp[i] = Math.max(dp[i], 1 + dp[check]);
                }
            }
            if(dp[i] == 0){
                dp[i] = 1;
            }
        }
        int max = -100;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max , dp[i]);
        }
        return max;
    }
}