class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            
        }
        return -1;






        // int counter = 0;
        // if(n == 1 && nums[n-1] == target){
        //     return n-1;
        // }
        // while(nums[low]>nums[high]){
        //     int temp = nums[high];
        //     for(int i=n-2;i>=0;i--){
        //         nums[i+1] = nums[i];
        //     }
        //     nums[0] = temp;
        //     counter++;
        // }

        // while (low <= high) {
        //     int mid = low + (high - low) / 2;

        //     if (nums[mid] == target) {
        //         int position = (mid - counter + n) % n;
        //         return position;
        //     } else if (nums[mid] > target) {
        //         high = mid - 1;
        //     } else {
        //         low = mid + 1;
        //     }
        // }
        // return -1;
    }
}