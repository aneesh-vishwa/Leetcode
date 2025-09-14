class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int max_sum = Integer.MIN_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            max_sum = Math.max(max_sum, sum);
            left++;
            right--;
        }
        return max_sum;
    }
}