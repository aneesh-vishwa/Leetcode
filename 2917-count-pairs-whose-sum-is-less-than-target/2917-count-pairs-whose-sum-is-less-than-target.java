class Solution {
    public int countPairs(List<Integer> nums, int target) {
        //sort the nums take the sum of left and right where left = 0 and right = size - 1 
        // if that sum is < target then add right - left to count;
        //by adding right - left to the count we are adding all the possible pair of sum < target to the count directly

        int left = 0;
        int right = nums.size() - 1;
        Collections.sort(nums);
        int count = 0;

        while(left < right){
            if(nums.get(left) + nums.get(right) < target){
                count += right- left;
                left++;
                //now updating left to new place and check for the paier less that target
            }
            else{
                right--;
            }
        }
        return count;
    }
}