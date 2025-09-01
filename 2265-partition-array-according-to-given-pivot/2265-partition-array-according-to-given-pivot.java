class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] output = new int[n];
        int l = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < pivot){
                output[l] = nums[i];
                l++;
            }
        }
        for(int j = 0 ; j < n ; j++){
            if(nums[j] == pivot){
                output[l] = nums[j];
                l++;
            }
        }
        for(int k = 0 ; k < n ; k++){
            if(nums[k] > pivot){
                output[l] = nums[k];
                l++;
            }
        }
        return output;
    }
}