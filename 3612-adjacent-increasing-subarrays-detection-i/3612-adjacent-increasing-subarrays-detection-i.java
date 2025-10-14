class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if(k == 1){
            return true;
        }
        
        int n = nums.size();
        for(int i = 0 ; i <= n - 2*k ; i++){
            boolean is_increasing_1 = true;
            boolean is_increasing_2 = true;
            for(int j = i + 1 ; j < i + k ; j++){
                if(nums.get(j) <= nums.get(j - 1)){
                    is_increasing_1 = false;
                    break;
                }
            }
            for(int l = i + k + 1 ; l < i + 2*k ; l++){
                if(nums.get(l) <= nums.get(l - 1)){
                    is_increasing_2 = false;
                    break;
                }
            }
            if(is_increasing_1 && is_increasing_2){
                return true;
            }
        }
        return false;
    }
}