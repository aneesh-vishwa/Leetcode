class Solution {
    public boolean check(int[] nums) {
        int irregular = 0;
        int k = nums.length;
        for(int i =0; i<k-1;i++){
            if(nums[i] > nums[i+1]){
                irregular += 1;
            }
        }
        if(nums[0]<nums[k-1]){
            irregular++;
        }
        if(irregular > 1 ){
            return false;
        }
        else return true;
    }
}