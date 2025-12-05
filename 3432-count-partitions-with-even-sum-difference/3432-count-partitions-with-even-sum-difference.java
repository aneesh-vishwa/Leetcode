class Solution {
    public int countPartitions(int[] nums) {
        int count = 0;
        int current_sum = 0;
        int total_sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            total_sum += nums[i];
        }

        for(int i = 0 ; i < nums.length - 1 ; i++){
            current_sum += nums[i];
            if((total_sum - 2*current_sum) % 2 == 0){
                count++;
            }
        }
        return count;
    }
}