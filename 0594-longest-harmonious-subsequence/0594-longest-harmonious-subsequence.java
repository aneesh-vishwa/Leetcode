class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int n = nums.length;
        int max_len = 0;

        while(right < n){
            while(nums[right] - nums[left] > 1){
                left++;
            }
            if(nums[right] - nums[left] == 1){
                max_len = Math.max(max_len , right - left + 1);
            }
            right++;
        }
        return max_len;
    }
}