class Solution {
    public int counting(int[] nums, int k, int l, int r) {
        int count = 0;
        int odds = 0;
        if (k < 0) {
            return 0;
        }
        int n = nums.length;
        while (r < n) {
            if (nums[r] % 2 != 0 && odds <= k) {
                odds++;
            }
            while (odds > k) {
                if (nums[l] % 2 != 0) {
                    odds--;
                }
                l++;
            }

            count += r - l + 1;
            r++;
        }
        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int count_great = counting(nums, k, l, r);
        int count = counting(nums, k - 1, l, r);

        return count_great - count;
    }
}