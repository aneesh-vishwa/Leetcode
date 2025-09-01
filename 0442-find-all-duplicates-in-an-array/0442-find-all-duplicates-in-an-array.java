class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        boolean[] arr = new boolean[n + 1];

        for(int i = 0 ; i < n ; i++){
            if(arr[nums[i]] == true){
                list.add(nums[i]);
            }
            else{
                arr[nums[i]] = true;
            }
        }
        return list;
    }
}