// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         HashSet<Integer> set = new HashSet<>();
//         for (int num : candidates) {
//             set.add(num);
//         }

//         List<List<Integer>> output = new ArrayList<>();

//         for (int num : candidates) {
//             ArrayList<Integer> list = new ArrayList<>();
//             int sum = 0;

//             while (sum + num <= target) {
//                 sum += num;
//                 list.add(num);

//                 if (sum == target) {
//                     Collections.sort(list);
//                         if(!output.contains(list)){
//                             output.add(list);
//                             break;
//                         }
//                     // output.add(new ArrayList<>(list));
                    
//                 }

//                 int remaining = target - sum;
//                 if (set.contains(remaining)) {
//                     ArrayList<Integer> temp = new ArrayList<>(list);
//                     temp.add(remaining);

//                     if (sum + remaining == target) {
//                         Collections.sort(temp);
//                         if(!output.contains(temp)){
//                             output.add(temp);
//                         }
                        
//                     }
//                 }
//             }
//         }

//         return output;
//     }
// }







class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        // int sum = 0;

        backtrack(0 , candidates , target , list , output);
        return output;
    }

    public void backtrack(int index , int[] candidates , int target , ArrayList<Integer> list , List<List<Integer>> output){
        if (target == 0) {
            output.add(new ArrayList<>(list));
            return;
        }
        
        if(index == candidates.length || target < 0){
            // sum += candidates[index];

            return;
        }

        //take
        list.add(candidates[index]);
        backtrack(index ,  candidates , target - candidates[index] , list , output);

        list.remove(list.size() - 1);
        backtrack(index+1 ,  candidates , target , list , output);
    }
}
