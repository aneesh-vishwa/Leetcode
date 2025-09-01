class Solution {
    public int findMin(int[] nums) {
        int n  = nums.length;
        int low = 0;
        int high = n - 1;
        int min = 5001;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[low] <= nums[mid]){
                min = Math.min(nums[low],min);
                low = mid + 1;
            }
            else{
                min = Math.min(nums[mid],min);
                high = mid - 1;
            }

        }
        return min;
    }
}