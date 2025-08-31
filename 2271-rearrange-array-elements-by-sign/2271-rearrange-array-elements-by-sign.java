class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        // brute force approach
        // int[] pa = new int[n/2];
        // int[] na = new int[n/2];
        // int[] res = new int[n];
        // int p_index = 0;
        // int n_index = 0;

        // for(int i=0;i<n;i++){
        //     if(nums[i] > 0){
        //         pa[p_index] = nums[i];
        //         p_index++;
        //     }
        //     else if(nums[i] < 0){
        //         na[n_index] = nums[i];
        //         n_index++;
        //     }
        // }
        // int pos = 0;
        // int neg = 0;
        // for(int i=0;i<n;i++){
        //     if(i%2 == 0){
        //         res[i] = pa[pos];
        //         pos++;
        //     }
        //     else if(i%2 != 0){
        //         res[i] = na[neg];
        //         neg++;

        //     }
        // }
        int p_index = 0;
        int n_index = 1;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                res[p_index] = nums[i];
                p_index +=2;
            }
            else if(nums[i] < 0){
                res[n_index] = nums[i];
                n_index +=2;
            }
        }
        return res;
    }
}