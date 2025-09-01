class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int output = nums[0] + nums[1] + nums[2]; 

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - total) < Math.abs(target - output)) {
                    output = total;
                }

                if (total < target) {
                    left++;
                } else if (total > target) {
                    right--;
                } else {
                    return target;
                }
            }
        }

        return output;
    }
}
