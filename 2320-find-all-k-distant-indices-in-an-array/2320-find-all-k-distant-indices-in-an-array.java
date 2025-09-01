class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> output = new ArrayList<>();
        ArrayList<Integer> idx_of_key = new ArrayList<>();

        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] == key){
                idx_of_key.add(i);
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == key){
                output.add(i);
            }
            else{
                for(int j = 0 ; j < idx_of_key.size() ; j++){
                    if(Math.abs(i - idx_of_key.get(j)) <= k){
                        output.add(i);
                        break;
                    }
                }

            }
        }
        return output;
    }
}