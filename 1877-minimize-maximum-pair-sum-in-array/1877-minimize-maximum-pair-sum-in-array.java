class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i_sum = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            i_sum = Math.max(i_sum , nums[i] + nums[n - i - 1]);
        }
        return i_sum;
    }
}