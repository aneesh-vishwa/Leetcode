class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int sum = 0;
        int min_len = Integer.MAX_VALUE;
        while(right < n){
            sum += nums[right];
            while(sum >= target){
                min_len = Math.min(min_len , right-left+1);
                sum = sum - nums[left];
                left++;
            }
            // if(sum >= target){
            //     min_len = Math.min(min_len , right-left+1);
            // }
            
            right++;
            
        }
        if(min_len == Integer.MAX_VALUE){
            return 0;
        }
        return min_len;
    }
}