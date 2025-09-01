class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int start = -1;
        int end = -1;

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
            if(nums[mid] == target) end = mid;
        }
            ans[1] = end;

            low = 0;
            high = n - 1;

            while(low <= high){
                int mid = (low + high)/2;
                if(nums[mid] < target){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
                if(nums[mid] == target){
                    start = mid;
                }
        }
        ans[0] = start;
        return ans;
    }
    
}