class Solution {
    public int removeElement(int[] nums, int val) {
        int insert_index = 0;
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] !=  val){
                nums[insert_index] = nums[i];
                insert_index++;
            }
        }
        return insert_index;
    }
}