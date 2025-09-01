class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        backtrack(0 , nums , list , output);
        return output;
    }
    public void backtrack(int index , int[] nums , ArrayList<Integer> list , List<List<Integer>> output){
        if(index == nums.length){
            output.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        backtrack(index+1 , nums , list , output);

        list.remove(list.size() - 1);
        backtrack(index + 1 , nums , list , output);

    }
}