class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int count = 0;

        for(int i = 1 ; i < n - 1 ; i++){
            int left = 0;
            int right = 0;

            if(nums[i] == nums[i - 1]){
                continue;
            }

            for(int j = i - 1 ; j >= 0 ; j--){
                if(nums[j] > nums[i]){
                    left = 1;
                    break;
                }
                else if(nums[j] < nums[i]){
                    left = -1;
                    break;
                }
            }

            for(int k = i + 1 ; k < n ; k++){
                if(nums[k] > nums[i]){
                    right = 1;
                    break;
                }
                else if(nums[k] < nums[i]){
                    right = -1;
                    break;
                }
            }
            if(left == right && left != 0 && right != 0){
                count++;
            }
        }
        return count;
    }
}