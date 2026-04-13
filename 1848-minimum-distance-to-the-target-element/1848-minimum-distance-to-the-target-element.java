class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int vars = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == target){
                vars = Math.min(vars , Math.abs(i - start));
            }
        }
        return vars;
    }
}