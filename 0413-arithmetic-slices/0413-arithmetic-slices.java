// class Solution {
//     public int numberOfArithmeticSlices(int[] nums) {
//         int n = nums.length;
//         if(n<3)return 0;
//         int count = 0;
//         int difference_count = 0;
//         int difference = Integer.MAX_VALUE;
//         for(int i = 1 ; i < n ; i++){
//             if(nums[i] - nums[i-1] == difference){
//                 difference_count++;
//                 count += difference_count;
//             }
//             else{
//                 difference_count = 0;
//             }
//             difference = nums[i] - nums[i-1];
//         }
//         return count;
//     }
// }

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        int count = 0;
        int current = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                current++;
                count += current;
            } else {
                current = 0;
            }
        }

        return count;
    }
}
