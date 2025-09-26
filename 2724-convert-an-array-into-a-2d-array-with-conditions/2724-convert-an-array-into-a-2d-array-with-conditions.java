class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        while (!map.isEmpty()) {
            int size = map.size();
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> to_remove = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if(value - 1 == 0){
                    to_remove.add(key);
                }
                else{
                    map.put(key , value - 1);
                }
                list.add(key);
            }
            for(int key : to_remove){
                map.remove(key);
            }
            ans.add(list);
        }
        return ans;

    }
}