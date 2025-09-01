class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int product = 1;
        int zero_count = 0;
        int[] ans = new int[n];

        for(int i = 0 ; i < n ; i++){
            if(nums[i] != 0 && zero_count <= 1){
                product *= nums[i];
            }
            else if(nums[i] == 0){
                zero_count++;
            }
            else if(zero_count > 1){
                product = 0;
                break;
            }
        }
        
        for(int j = 0 ; j < n ; j++){
            if(zero_count == 0){
                ans[j] = product / nums[j];
            }
            else if(zero_count == 1){
                if(nums[j] == 0){
                    ans[j] = product;
                }
                else{
                    ans[j] = 0;
                }
            }
            else{
                ans[j] = 0;
            }
        }
        return ans;
    }
}