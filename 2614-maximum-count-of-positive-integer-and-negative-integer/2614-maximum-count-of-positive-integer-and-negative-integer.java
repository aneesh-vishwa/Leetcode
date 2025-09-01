class Solution {
    public int maximumCount(int[] nums) {
        int neg_count = 0;
        int pos_count = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < 0){
                neg_count++;
            }
            else if(nums[i] > 0){
                pos_count++;
            }
        }
        int res = Math.max(neg_count , pos_count);
        return res;
    }
}