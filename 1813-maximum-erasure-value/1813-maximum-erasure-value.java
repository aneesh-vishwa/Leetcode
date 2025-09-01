class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>(); // nums[i] , index

        int n = nums.length;

        int left = 0;
        int sum = 0;

        int max_sum = Integer.MIN_VALUE;


        for(int right = 0 ; right < n ; right++){
            if(map.containsKey(nums[right])){
                int index = map.get(nums[right]);
                while(left <= index){
                    sum -= nums[left];
                    map.remove(nums[left]);
                    left++;
                }
            }
            sum += nums[right];
            map.put(nums[right] , right);
            max_sum = Math.max(max_sum , sum);
        }
        return max_sum;
    }
}