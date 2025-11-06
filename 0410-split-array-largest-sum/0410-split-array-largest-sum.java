class Solution {
    public int splitArray(int[] nums, int k) {
        //book allocation problem
        int n = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int ans = max;

        if (k > n) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        int left = max;
        int right = sum;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (no_of_k_needed(mid, nums) <= k) { //search for a better mid value les than this where we can accomadate in k blocks
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int no_of_k_needed(int sum, int[] nums) {
        int n = nums.length;
        int no_of_blocks_needed = 1;

        int current_sum_of_that_block = 0;
        for (int i = 0; i < n; i++) {
            if (current_sum_of_that_block + nums[i] <= sum) {
                current_sum_of_that_block += nums[i];
            } else {
                no_of_blocks_needed++;
                current_sum_of_that_block = nums[i];
            }
        }
        return no_of_blocks_needed;
    }
}