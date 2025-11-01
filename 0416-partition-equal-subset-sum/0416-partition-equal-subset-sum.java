class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;

        boolean[][] dp = new boolean[n + 1][target + 1];
        // n + 1 rows → for the elements in the array
        // target + 1 columns → for all possible sums from 0 to target

        //it is always true idf the target is 0
        for(int col = 0 ; col < n ; col++){
            dp[col][0] = true;//for zeroth col
        }

        for(int i = 0 ; i < n ; i++){//for nums[] array 
            for(int current_target = 1 ; current_target <= target ; current_target++){//for target 1 , 2 , 3 , 4 ,........ target
                if(nums[i] <= current_target){
                    dp[i + 1][current_target] = dp[i][current_target - nums[i]] || dp[i][current_target];
                }
                else{
                    dp[i + 1][current_target] = dp[i][current_target];
                }
            }
            
        }
        return dp[n][target];



        // return helper(nums , target , 0);
    }
    // public static boolean helper(int[] nums , int target , int index){
    //     if(target == 0){
    //         return true;
    //     }
    //     if(index >= nums.length || target < 0){
    //         return false;
    //     }
    //     if (nums[index] > target) return helper(nums , target , index + 1);
    //     // if(target - nums[index] >= 0){
    //     //     return helper(nums , target - nums[index] , index + 1);
    //     // }

    //     return helper(nums , target - nums[index] , index + 1) || helper(nums , target , index + 1);
    // }
}