class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0L; 
        int n = nums.length;
        int i = 0;

        while (i < n) {
            if (nums[i] != 0) {
                i++;
                continue;
            }

            int left = i;
            int right = i;

            while (right < n && nums[right] == 0) {
                right++;
            }

            long len = right - left; 
            ans += (len * (len + 1)) / 2;

            i = right;
        }

        return ans;
    }
}