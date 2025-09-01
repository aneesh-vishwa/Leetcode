class Solution {
    public int removeDuplicates(int[] nums) {
        // if n <= 2 we can return direcctly

        int n = nums.length;
        if(n <= 2){
            return n;
        }

        // now we are allowed to keep only two duplicates , 0,0,1,1,1,1,2,3,3 
        //we will leaves first two places in the array caues it doesnot matter if they aare duplicates are different ,
        /* whatever it may be but they remain same as we are allowed max 2 duplicates 
        now we will run the loop from i = 2 to n and check if nums[i] == nums[j - 2] 
        think (if they are equal then there are mmore than 2 duplicates in the array and we need to replace them)
        */

        int j = 2;
        for(int i = 2 ; i < n ; i++){
            if(nums[i] != nums[j - 2]){
                nums[j] = nums[i];
                j++;
            }

        }
        return j;

    }
}