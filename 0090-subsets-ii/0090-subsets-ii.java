class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, output, list, 0);
        Set<List<Integer>> set = new LinkedHashSet<>();
        for (List<Integer> inner : output) {
            set.add(new ArrayList<>(inner)); // Clone to avoid issues with references
        }
        return new ArrayList<>(set);
        // return output;
    }

    public void backtrack(int[] nums, List<List<Integer>> output, List<Integer> list, int index) {
        if (index == nums.length) {
            output.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        backtrack(nums, output, list, index + 1);

        list.remove(list.size() - 1);
        backtrack(nums, output, list, index + 1);

    }
}