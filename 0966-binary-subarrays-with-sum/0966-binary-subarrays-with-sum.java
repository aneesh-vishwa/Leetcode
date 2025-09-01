class Solution {
    public int counting(int[] nums, int goal, int l, int r){
        if(goal < 0){
            return 0;
        }
        int count = 0;
        int sum = 0;
        int n = nums.length;
         while(r < n){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            if(sum <= goal){
                count += r-l+1;
            }
            r++;
        }
        return count;
    } 
    public int numSubarraysWithSum(int[] nums, int goal) {
        int l = 0;
        int r = 0;

        int count_great = counting(nums,goal,0,0);
        int count = counting(nums,goal-1,0,0);

        return count_great - count;
    }
}