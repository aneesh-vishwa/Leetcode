class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int min = 1; 
        int max = 0; 
        for(int i=0;i<n;i++){
            // min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        int low = min;
        int high = max;
        int ans = 0;
        while(low <= high){
            int mid = (low + high)/2;
            int sum = 0;
            for(int i = 0;i<n;i++){
                sum += (nums[i] + mid -1)/mid;
            }
            if(sum <= threshold){
                high = mid - 1;
                ans = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}