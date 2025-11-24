class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        ArrayList<Boolean> ans = new ArrayList<>();
        int n = nums.length;

        int current = 0;
        int two_power = 1;

        for(int i = 0 ; i < n ; i++){
            // two_power = two_power * 2;
            // current = current + nums[i] * two_power;


            two_power = (two_power * 2) % 5;
            current = (current * 2 + nums[i]) % 5;

            if(current % 5 == 0){
                ans.add(true);
            }
            else{
                ans.add(false);
            }

        }
        return ans;
    }
}