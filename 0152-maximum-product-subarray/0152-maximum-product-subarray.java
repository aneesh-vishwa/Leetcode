class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int max_prefix = Integer.MIN_VALUE;
        int suffix = 1;
        int max_suffix = Integer.MIN_VALUE;
        int l = 0;
        int r = n-1;
        
        while(l<n){
            prefix = prefix * nums[l];
            max_prefix = Math.max(max_prefix , prefix);
            if(nums[l] == 0){
                prefix = 1;
            }
            l++;
        }
        while(r>=0){
            suffix = suffix * nums[r];
            max_suffix = Math.max(max_suffix, suffix);
            if(nums[r] == 0){
                suffix = 1;
            }
            r--;
        }
        return Math.max(max_prefix, max_suffix);
    }
}