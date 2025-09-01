class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> output = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        backtrack(0 , candidates , target , list , output);
        return output;
    }
    public void backtrack(int index , int[] candidates , int target , ArrayList<Integer> list , List<List<Integer>> output){
        if(target == 0){
            output.add(new ArrayList<>(list));
            return;
        }
        if(index == candidates.length || target < 0){
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break; // Early stopping since array is sorted

            list.add(candidates[i]);
            backtrack(i + 1, candidates, target - candidates[i], list, output); // i+1 to not reuse same element
            list.remove(list.size() - 1);
        }

        // list.add(candidates[index]);
        // backtrack(index + 1 , candidates , target - candidates[index] , list , output);

        // list.remove(list.size() - 1);
        // backtrack(index + 1 , candidates , target , list , output);
    }
}