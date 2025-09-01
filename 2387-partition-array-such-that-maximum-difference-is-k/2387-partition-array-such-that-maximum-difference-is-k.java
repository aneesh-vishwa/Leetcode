class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 1){
            return 1;
        }
        int count = 0;
        int left = 0;
        int right = 1;
        while(right < n){
            if(nums[right] - nums[left] <= k){
                right++;
            }
            else{
                left = right;
                count++;
            }
        }
        return count+1;
    }
}