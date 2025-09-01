class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            int no_of_missing = arr[mid] - mid - 1;
            if(no_of_missing >= k){
                high = mid - 1;
            }
            else if(no_of_missing < k){
                low = mid+1;
            }
            
        }
        return k + high + 1;



















        // ArrayList<Integer> nums = new ArrayList<>();
        
        // for(int i = 1; i <= arr[n - 1] + k; i++){
        //     nums.add(i);
        // }
        
        // for(int i = 0; i < n; i++){
        //     nums.remove(Integer.valueOf(arr[i]));
        // }
        
        // if(nums.size() == 0){
        //     return arr[n - 1] + k;
        // }
        
        // return nums.get(k - 1);
    }
}
