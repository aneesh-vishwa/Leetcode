class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer,Integer> res = new HashMap<>();
        for(int num : nums){
            res.put(num, res.getOrDefault(num, 0) + 1);
        }
         for (int num : res.keySet()) {
            if (res.get(num) > n / 3 && !output.contains(num)) {
                output.add(num);
            }
        }
        // for(int i=0;i<nums.length;i++){
        //     if(res.get(nums[i]) > n/3){
        //         output.add(nums[i]);
        //     }
        // }
        return output;
    }
}