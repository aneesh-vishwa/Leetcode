class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);

        int n  = nums.length;

        if(n < 2){
            return 0;
        }
        int max_diff = 0;
        for(int i = 1 ; i < n ; i++){
            if(nums[i] - nums[i-1] > max_diff)
            {
                max_diff = nums[i] - nums[i-1];
            }
            
        }
        return max_diff;
    }
}