class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n];

        int[] arr = new int[n + 1];

        for(int[] inside_query : queries){
            int start = inside_query[0];
            int end = inside_query[1];

            arr[start]++;
            if(end + 1 < n){
                arr[end + 1]--;
            }
        }
        // construction of a prefix array for our arr generated

        prefix[0] = arr[0];

        for(int i = 1 ; i < n ; i++){
            prefix[i] = prefix[i - 1] + arr[i];
        }

        // we got the prefix array and also have the input array 
        // what is the objective of creating a prefix array?

        // substraction of prefix from input which should give us zero array to retun true else dfaflse

        for(int k = 0 ; k < n ; k++){
            if(nums[k] - prefix[k] > 0){
                return false;
            }
        }
        return true;
    }
}