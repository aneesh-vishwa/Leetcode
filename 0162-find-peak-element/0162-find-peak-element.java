class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int peak = -1;
        if(n == 1){
            return n-1;
        }
        for(int i=1;i<n-1;i++){
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
                peak = Math.max(peak,i);
            }
        }
        if(nums[0] > nums[1]){
            peak = Math.max(peak,0);
        }
        if(nums[n-1] > nums[n-2]){
            peak = Math.max(peak,n-1);
        }
        return peak;
    }
}