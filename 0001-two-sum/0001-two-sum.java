import java.util.Arrays;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int[] output = new int[2];

        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i] , i);
        }
        for(int j = 0 ; j < nums.length ; j++){
            if(map.containsKey(target - nums[j]) && j != map.get(target - nums[j])){
                output[0] = j;
                output[1] = map.get(target - nums[j]);
                return output;
            }
        }

    //     Arays.sort(nums);
    //     int n = nums.length;
    //     int low = 0;
    //     int high = n;
    //     while(low <= high){
    //         int mid = (low + high)/2;
    //         if(nums[mid]> target){
    //             high = mid -1;
    //         }
    //     }
    //     for(int i = 0; i < nums.length - 1; i++){
    //          if(nums[i] + nums[i+1] == target){
    //              return new int[] {i,i+1};
    //             }
    //         // for(int j = i+1 ; j<nums.length;j++){
    //         //     if(nums[i] + nums[j] == target){
    //         //      return new int[] {i,j};
    //         //     }
    //         // }
    //     }
      return new int[] {};
    }


}