// class Solution {
//     public void moveZeroes(int[] nums) {
//         int l =0;
//         for(int r = 1; r<nums.length;r++){
//             if(nums[l] != 0 && nums[r] == 0){
//                 int temp = nums[r];
//                 nums[r] = nums[r+1];
//                 nums[r+1] = temp;
//                 l++;
//                 r++;
//             }
//             else if(nums[l] == 0 && nums[r] != 0){
//                 int temp = nums[r];
//                 nums[r] = nums[l];
//                 nums[l] = temp;
//                 l++;
//             }
//         }
//     }
// }

class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }        
    }
}