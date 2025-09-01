class Solution {
    public void sortColors(int[] nums) {
        // try to push 0 to left and 2 to right to get an optimal solution
        int n = nums.length;
        // int temp = 0;
        // for(int i = 0;i < n-1;i++){
        //     for(int j  = i + 1;j < n;j++){
        //         if(nums[i] > nums[j]){
        //             temp = nums[i];
        //             nums[i] = nums[j];
        //             nums[j] = temp;

        //         }
        //     }
        // }
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i = 0;i<n;i++){
            if(nums[i] == 0){
                count0++;
            }
            else if(nums[i] == 1){
                count1++;
            }
            else{
                count2++;
            }
        }

        for(int i = 0;i<count0;i++){
            nums[i] = 0;
        }

        for(int i = count0;i<(count0+count1);i++){
            nums[i] = 1;
        }

        for(int i = (count0+count1);i<n;i++){
            nums[i] = 2;
        }

    }
}