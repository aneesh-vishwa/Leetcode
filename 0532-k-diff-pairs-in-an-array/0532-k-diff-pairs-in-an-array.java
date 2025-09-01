class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        int left = 0;
        int right = 1;

        while (left < n && right < n) {
            if (left == right || nums[right] - nums[left] < k) {
                right++;
            } else if (nums[right] - nums[left] > k) {
                left++;
            } else {
                count++;
                left++;
                while (left < n && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
        return count;
    }
}