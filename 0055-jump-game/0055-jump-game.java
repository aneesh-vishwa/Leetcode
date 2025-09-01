class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max_ind = 0;
        for(int i=0;i<n;i++){
            if(i > max_ind){
                return false;
            }
            max_ind = Math.max(max_ind, i+nums[i]);
        }
        return true;
    }
}