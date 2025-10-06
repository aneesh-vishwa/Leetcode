class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        ArrayList<Boolean> list = new ArrayList<>();

        // int[] diff = new int[n - 1];

        // for(int i = 1 ; i < n ; i++){
        //     diff[i - 1] = nums[i] - nums[i - 1];
        // }

        for(int i = 0 ; i < m ; i++){
            int start = l[i];
            int end = r[i];
            int[] arr = new int[end - start + 1];

            for(int k = 0 ; k < arr.length ; k++){
                arr[k] = nums[l[i] + k];
            }

            list.add(verify(arr));

        }
        return list;
    }

    public boolean verify(int[] arr){
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for(int i = 2 ; i < arr.length ; i++){
            if(diff != arr[i] - arr[i - 1]){
                return false;
            }
        }
        return true;
    }
}