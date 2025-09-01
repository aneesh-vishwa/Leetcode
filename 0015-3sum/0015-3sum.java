class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0 ; i < n - 2 ; i++){
            if(i > 0 && nums[i] == nums[i -1]){
                continue;
            }
            int left = i + 1;
            int right = n - 1;

            while(left < right){

                if(nums[i] + nums[left] + nums[right] == 0){

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;


                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);

                    output.add(list);

                    left++;
                    right--;
                }
                else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }
                else{//nums[i] + nums[left] + nums[right] > 0
                    right--;
                }
            }
        }
        return output;
    }
}