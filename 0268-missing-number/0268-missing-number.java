class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum2 = 0;
        if(n == 0){
            return 0;
        }
        int sum1 = (n*(n+1))/2;
        for(int i = 0;i<n;i++){
            sum2 += nums[i];
        }
        
        int result = sum1 - sum2;
        return result;

    }
}