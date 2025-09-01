class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            set.add(nums[i]);
            max = Math.max(max , nums[i]);
        }
        int i = 1;
        while(i <= max){
            if(!set.contains(i)){
                return i;
            }
            i++;
        }
        // for(int i = 1 ; i < max ; i++){
        //     if(!set.contains(i)){
        //         return i;
        //     }
        // }
        return max+1;
    }
}