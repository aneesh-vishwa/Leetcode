class Solution {
    public int maxSubArray(int[] nums) {
        int length = 0;
        int sum = 0;
        int max_sum = nums[0];
        int i = 0;
        while(i < nums.length){
            sum += nums[i];
            max_sum = Math.max(max_sum , sum);

            if(sum < 0){
                sum = 0;
            }
            i++;
        }
        return max_sum;
    }
}