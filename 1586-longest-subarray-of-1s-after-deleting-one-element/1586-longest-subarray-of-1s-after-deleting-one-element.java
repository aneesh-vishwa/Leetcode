class Solution {
    public int longestSubarray(int[] nums) {
        int count = 0;
        int max_count = -1;
        int zero_count = 0;

        int left = 0;
        // int right = 0;

        for(int right = 0 ; right < nums.length ; right++){
            if(nums[right] == 0){
                zero_count++;
            }
            while(zero_count >= 2){
                if(nums[left] == 1){
                    count--;
                }
                else if(nums[left] == 0){
                    zero_count--;
                }
                left++;
            }
            if(nums[right] == 1){
                count++;
            }
            max_count = Math.max(max_count , count);
        }
        if(zero_count == 0){
            return max_count - 1;
        }
        return max_count;
    }
}