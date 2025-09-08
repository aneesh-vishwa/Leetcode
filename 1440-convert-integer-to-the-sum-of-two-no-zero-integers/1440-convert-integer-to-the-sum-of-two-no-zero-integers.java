class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int first = i;
            while(first%10 > 0){
                if(first % 10 == 0){
                    break;
                }
                if (first % 10 != 0) {
                    first = first/10;
                }
            }
            // if (i % 10 == 0) {
            //     continue;
            // }
            int second = n - i;
            while (second > 0) {
                if(second % 10 == 0){
                    break;
                }
                if (second % 10 != 0) {
                    second = second/10;
                    // return new int[] { i, n - i };
                }
            }
            if(second == 0 && first == 0){
                return new int[]{i , (n - i)};
            }

        }
        return new int[] {};
        // if((n-1)%10 != 0){
        //     return new int[]{1 , n - 1};
        // }
        // else{
        //     return new int[] {2 , n - 2};
        // }
    }
}