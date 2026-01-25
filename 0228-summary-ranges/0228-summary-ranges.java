class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> output = new ArrayList<>();
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while(i < nums.length){
            sb.append(nums[i]);
            int count = 0;
            while(i+1 < nums.length && nums[i + 1] - nums[i] == 1){
                count++;
                i++;
            }
            if(count > 0){
                sb.append("->");
                sb.append(nums[i]);
            }
            output.add(sb.toString());
            sb.delete(0, sb.length());
            i++;
        }
        return output;
    }
}