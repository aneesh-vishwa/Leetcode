class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int str_len = nums[0].length();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(int i = 0 ; i < n ; i++){
            if(sb.length() == n){
                break;
            }
            int add = 1 - (nums[i].charAt(k) - '0');
            sb.append(add);
            k++;
        }
        return sb.toString();
    }
}