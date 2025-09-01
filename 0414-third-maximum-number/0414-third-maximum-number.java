class Solution {
    public int thirdMax(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
        }

        int n = nums.length;


        if(n == 2){
            return Math.max(nums[0] , nums[1]);
        }

        if(n == 1){
            return nums[0];
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] > first){
                third = second;
                second = first;
                first = nums[i];
            }

            else if(nums[i] > second && nums[i] != first){
                third = second;
                second = nums[i];
            }
            else if(nums[i] > third && nums[i] != second && nums[i] != first){
                third = nums[i];
            }
        }
        if((third == Integer.MIN_VALUE && !set.contains(third)) || set.size() < 3){
            return first;
        }
        return third;
    }
}