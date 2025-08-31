class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int counter = 1;
        int max_counter = 1;
        int[] num = new int[n];;
        Arrays.sort(nums);

        ArrayList<Integer> unique = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                unique.add(nums[i]);
            }
        }
        for(int j=1;j<unique.size();j++){
            if(unique.get(j) - unique.get(j-1) == 1){
                counter++;
            }
            else{
                counter = 1;
                
            }
            max_counter = Math.max(max_counter,counter);
        }
        

        return max_counter;
    }
    
}

