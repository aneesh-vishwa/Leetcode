class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        int largest_num = Integer.MIN_VALUE;

        if(nums.length == 1){
            return nums[0];
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= 0){
                largest_num = Math.max(largest_num , nums[i]);
                continue;
            }
            largest_num = Math.max(largest_num , nums[i]);
            set.add(nums[i]);
        }

        if(set.size() == 0){
            return largest_num;
        }

        for(int num : set){
            sum += num;
        }

        return sum;
    }
}