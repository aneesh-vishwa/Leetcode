class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        //2 , 3 , 5
        int i_2 = 0;
        int i_3 = 0;
        int i_5 = 0;

        for(int i = 1 ; i < n ; i++){

            int next_2 = nums[i_2] * 2;
            int next_3 = nums[i_3] * 3;
            int next_5 = nums[i_5] * 5;

            int current = Math.min(next_2, Math.min(next_3, next_5));

            nums[i] = current;

            if(current % 2 == 0){
                i_2++;
            }
            if(current % 3 == 0){
                i_3++;
            }
            if(current % 5 == 0){
                i_5++;
            }
        }
        return nums[n - 1];
    }
}