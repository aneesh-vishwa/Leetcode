class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] output = new int[2];
        int[] freq = new int[n];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            if(freq[nums[i]] == 1){
                list.add(nums[i]);
            }
            freq[nums[i]]++;
        }
        output[0] = list.get(0);
        output[1] = list.get(1);
        return output;
    }
}