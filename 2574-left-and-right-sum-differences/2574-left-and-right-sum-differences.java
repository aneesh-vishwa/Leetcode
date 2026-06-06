class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] left_sum = new int[n];
        int[] right_sum = new int[n];
        left_sum[0] = 0;
        right_sum[n - 1] = 0;

        for(int i = 0 ; i < n - 1 ; i++){
            left_sum[i + 1] = left_sum[i] + nums[i];
        }

        for(int i = n - 2 ; i >= 0 ; i--){
            right_sum[i] = right_sum[i + 1] + nums[i + 1];
        }
        int[] result = new int[n];

        for(int i = 0 ; i < n ; i++){
            result[i] = Math.abs(left_sum[i] - right_sum[i]);
        }
        return result;
    }
}