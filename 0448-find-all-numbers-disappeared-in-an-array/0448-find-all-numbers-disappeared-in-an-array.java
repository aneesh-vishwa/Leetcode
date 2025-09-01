class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        boolean[] arr = new boolean[n + 1];

        for(int i = 0 ; i < n ; i++){
            arr[nums[i]] = true;
        }

        for(int j = 1 ; j < n + 1 ; j++){
            if(arr[j] == false){
                list.add(j);
            }
        }
        return list;
    }
}