class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n == 1){
            return 0;
        }
        int min_possible = Integer.MAX_VALUE;
        for(int i = 0 ; i + k - 1 < n ; i++){
            min_possible = Math.min(min_possible , nums[i + k - 1] - nums[i]);
        }
        return min_possible;
    }
}