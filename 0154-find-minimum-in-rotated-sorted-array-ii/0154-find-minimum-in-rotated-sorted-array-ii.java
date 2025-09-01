class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int left = 0;
        int right = n-1;
        int ans = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left)/2;
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                ans = Math.min(ans, nums[mid]);
                left++;
                right--;
                continue;
            }
            if(nums[left] <= nums[mid]){//left <= mid && 
                ans = Math.min(ans , nums[left]);
                left = mid + 1;
                
            }
            else{
                ans = Math.min(ans , nums[mid]);
                right = mid - 1;
            }
        }
        return ans;
    }
}