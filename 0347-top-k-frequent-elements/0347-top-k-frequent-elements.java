class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (Integer key : map.keySet()) {
            pq.add(key);
        }

        int[] output = new int[k];
        for (int j = 0; j < k; j++) {
            int temp = pq.poll();
            output[j] = temp;
        }
        return output;
    }
}