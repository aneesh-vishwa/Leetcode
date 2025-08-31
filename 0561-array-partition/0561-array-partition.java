class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int sum = 0;
        for(int i =0; i < length; i+=2){
            sum += nums[i];
        }
        return sum;
    }
}