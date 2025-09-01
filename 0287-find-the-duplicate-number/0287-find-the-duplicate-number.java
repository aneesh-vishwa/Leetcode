class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] visited = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(visited[nums[i]] == 1){
                return nums[i];
            }
            visited[nums[i]] = 1;
        }
        return 0;
    }
}